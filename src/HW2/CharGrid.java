package HW2;


public class CharGrid {
  public static char[][] grid;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        grid = new char[n][m];
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            for(int j = 0; j < m; j++){
                grid[i][j] = line.charAt(j);
            }
        }
        char c = sc.next().charAt(0);
        System.out.println(charArea(c));
        int count = countPlus();
        System.out.println(count);
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
