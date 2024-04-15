package HW2;


public class CharGrid {
    private static char[][] grid = new char[10][10];
    public CharGrid(char[][] grid){
        this.grid = grid;
    }
    public static void main(String[] args) {
      char[][] gridd = {
              {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
              {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
              {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
              {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
              {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
              {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
              {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}

      };
      CharGrid grid = new CharGrid(gridd);
        int n = countPlus();
        System.out.println(n);
    }

    public int charArea(char ch) {
        int rows = grid.length;
        int cols = grid[0].length;
        int min_row = rows;
        int max_row = -1;
        int min_col = cols;
        int max_col = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == ch) {
                    min_row = Math.min(min_row, i);
                    max_row = Math.max(max_row, i);
                    min_col = Math.min(min_col, j);
                    max_col = Math.max(max_col, j);
                }
            }
        }
        int length = max_row - min_row + 1;
        int width = max_col - min_col + 1;
        return length * width;
    }
    public static boolean check(int row, int col){
        char center = grid[row][col];
        int l1 = 1; int l2 = 1; int l3 = 1; int l4 = 1;
        //xet nhanh phia tren
        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] == center){
                l1++;
            }
            else break;
        }
        //xet nhanh phia duoi
        for(int i = row + 1; i < grid.length; i++){
            if(grid[i][col] == center){
                l2++;
            }
            else break;
        }
        for(int j = col - 1; j >= 0; j--){
            if(grid[row][j] == center){
                l3++;
            }
            else break;
        }
        for(int j = col + 1; j < grid[row].length; j++){
            if(grid[row][j] == center){
                l4++;
            }
            else break;
        }
        return l1 == l2 && l2 == l3 && l3 == l4 && l1 >= 2 && l2 >= 2 && l3 >= 2 && l4 >= 2;
    }

    public static int countPlus() {
        int cnt = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] != ' '){
                    if(check(i, j)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
