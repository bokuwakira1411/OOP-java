// Board.java

/**
 * CS108 Tetris Board.
 * Represents a Tetris board -- essentially a 2-d grid
 * of booleans. Supports tetris pieces and row clearing.
 * Has an "undo" feature that allows clients to add and remove pieces efficiently.
 * Does not do any drawing or have any idea of pixels. Instead,
 * just represents the abstract 2-d board.
 */
public class Board {
    // Some ivars are stubbed out for you:
    private int width;
    private int height;
    private boolean[][] grid;
    private boolean DEBUG = true;
    private static int[] widths;
    private static int[] heights;
    private int maxHeight;
    boolean committed;

    // Here a few trivial methods are provided:

    /**
     * Creates an empty board of the given width and height
     * measured in blocks.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        committed = true;
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                grid[i][j] = false;
            }
        }
        widths = new int[height];
        heights = new int[width];
        for(int i = 0; i < height; i++){
            widths[i] = 0;
        }
        for(int i = 0; i < width; i++){
            heights[i] = 0;
        }
    }


    /**
     * Returns the width of the board in blocks.
     */
    public int getWidth() {
        return width;
    }


    /**
     * Returns the height of the board in blocks.
     */
    public int getHeight() {
        return height;
    }


    /**
     * Returns the max column height present in the board.
     * For an empty board this is 0.
     */
    public int getMaxHeight() {
        return maxHeight;
    }


    /**
     * Checks the board for internal consistency -- used
     * for debugging.
     */
    public void sanityCheck() {
        if (DEBUG) {
            // YOUR CODE HERE
            
        }
    }

    /**
     * Given a piece and an x, returns the y
     * value where the piece would come to rest
     * if it were dropped straight down at that x.
     *
     * <p>
     * Implementation: use the skirt and the col heights
     * to compute this fast -- O(skirt length).
     */
    public int dropHeight(Piece piece, int x) {
        int drop = 0;
        for(int i = 0; i < piece.getWidth(); i++){
            drop = Math.max(drop, heights[i + x] - piece.getSkirt()[i]);
        }
        return drop; 
    }


    /**
     * Returns the height of the given column --
     * i.e. the y value of the highest block + 1.
     * The height is 0 if the column contains no blocks.
     */
    public int getColumnHeight(int x) {
        return heights[x]; 

    }


    /**
     * Returns the number of filled blocks in
     * the given row.
     */
    public int getRowWidth(int y) {
        return widths[y]; // YOUR CODE HERE
        
    }


    /**
     * Returns true if the given block is filled in the board.
     * Blocks outside of the valid width/height area
     * always return true.
     */
    public boolean getGrid(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return true;
        }
        return grid[x][y];// YOUR CODE HERE
    }


    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     *
     * <p>Error cases:
     * A placement may fail in two ways. First, if part of the piece may falls out
     * of bounds of the board, PLACE_OUT_BOUNDS is returned.
     * Or the placement may collide with existing blocks in the grid
     * in which case PLACE_BAD is returned.
     * In both error cases, the board may be left in an invalid
     * state. The client can use undo(), to recover the valid, pre-place state.
     */
    public int place(Piece piece, int x, int y) {
        // flag !committed problem
        if (!committed) throw new RuntimeException("place commit problem");

        int result = PLACE_OK;
        for(int i = 0; i < piece.getBody().length; i++){
            int X = x + piece.getBody()[i].x;
            int Y = y + piece.getBody()[i].y;
            if((X < 0 || X >= width) || (Y < 0 || Y >= height)){
                result = PLACE_OUT_BOUNDS;
                return result;
            }
            if(grid[X][Y]){
                result = PLACE_BAD;
                return result;
            }
            grid[X][Y] = true;
            widths[Y]++;
            if(widths[Y] == width){
                result = PLACE_ROW_FILLED;
            }
            maxHeight = Math.max(maxHeight, Math.max(Y + 1, heights[X]));
        }
        
        return result;
    }


    /**
     * Deletes rows that are filled all the way across, moving
     * things above down. Returns the number of rows cleared.
     */
    public int clearRows() {
        int rowsCleared = 0;
        int cnt = 0;
        // YOUR CODE HERE
        for(int i = 0; i < maxHeight - rowsCleared; i++){
            cnt++;
            while(widths[cnt] == width){
                cnt++;
                rowsCleared++;
            }
            for(int j = 0; j < width; i++){
                grid[j][i] = grid[j][cnt];
                widths[i] = widths[cnt];
            }
        }
        sanityCheck();
        return rowsCleared;
    }


    /**
     * Reverts the board to its state before up to one place
     * and one clearRows();
     * If the conditions for undo() are not met, such as
     * calling undo() twice in a row, then the second undo() does nothing.
     * See the overview docs.
     */
    public void undo() {
        // YOUR CODE HERE
    }


    /**
     * Puts the board in the committed state.
     */
    public void commit() {
        committed = true;
    }


    /*
     Renders the board state as a big String, suitable for printing.
     This is the sort of print-obj-state utility that can help see complex
     state change over time.
     (provided debugging utility)
     */
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (int y = height - 1; y >= 0; y--) {
            buff.append('|');
            for (int x = 0; x < width; x++) {
                if (getGrid(x, y)) buff.append('+');
                else buff.append(' ');
            }
            buff.append("|\n");
        }
        for (int x = 0; x < width + 2; x++) buff.append('-');
        return (buff.toString());
    }
}


