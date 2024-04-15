package HW2;

public class TetrisGrid {
    static boolean[][] grid;

    public static void main(String[] args) {
        grid = new boolean[][]{
                {true, false, false},
                {false, true, true},
                {true, true, true},
                {true, true, false},
                {true, true, true}
        };
        clearRows();
    }
    public static void clearRows() {
        int count = 0;
        boolean[] used = new boolean[1000];
       for(int i = 0; i < grid.length; i++){
           int cnt = 0;
           for(int j = 0; j < grid[i].length - 1; j++){
               if(grid[i][j] == grid[i][j + 1]){
                   cnt++;
               }
           }
           if(cnt == grid[i].length - 1) {
               used[i] = true;
               count++;
           }
       }
       for(int i = 0; i < count; i++) {
           System.out.println();
       }
       for(int i = 0; i < grid.length; i++) {
           if (!used[i]) {
               for (int j = 0; j < grid[i].length; j++) {
                  System.out.print(grid[i][j] + " ");
               }
               System.out.println();
           }
       }
    }


}