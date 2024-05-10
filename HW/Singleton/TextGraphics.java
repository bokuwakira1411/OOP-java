package Singleton;
public class TextGraphics{
    private static TextGraphics instance;
    private static char[][] grid;
    private static int width, height;
    public TextGraphics(char[][] grid){
        this.grid = grid;
    }
    public static TextGraphics getInstance(){
        if(instance == null){
            instance = new TextGraphics(new char[width][height]);
        }
        return instance;
    }
    public void init(int width, int height){
        this.width = width;
        this.height = height;
        grid = new char[width][height];
    }
    public void drawPoint(char c, int x, int y){
        grid[x][y] = c;
    }
    public void drawLine(char c, int x1, int y1, int x2, int y2){
        double a = (y2 - y1) /(x2 - x1);
        double b = y1 - a*x1;
        for(int i = x1; i <= x2; i++){
            drawPoint(c, i, (int) (i*a + b));
        } 
    }
    public void fillRect(char c, int x, int y, int width, int height){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                drawPoint(c, x + i, y + j);
            }
        }
    }
    public void render(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}