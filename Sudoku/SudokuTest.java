package Sudoku;//package Sudoku;
////
////
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;Easy.addActionListener(new ActionListener(){
////    @Override
////    public void actionPerformed(ActionEvent e){
////        openEasyGame();
////    }
////});
////        Medium.addActionListener(new ActionListener(){
////    @Override
////    public void actionPerformed(ActionEvent e){
////        openMediumGame();
////    }
////});
////        Hard.addActionListener(new ActionListener(){
////    @Override
////    public void actionPerformed(ActionEvent e){
////        openHardGame();
////    }
////});
//public class SudokuMain {
//
//    private static final int SIZE = 9;
//    private static int[][] Grid;
//    public SudokuMain(int[][] initialGrid) {
//        Grid = new int[SIZE][SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                Grid[i][j] = initialGrid[i][j];
//            }
//        }
//    }
//
//    public int[][] getGrid() {
//        return Grid;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                sb.append(Grid[i][j]).append(" ");
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//
//    public static int[][] stringToGrid(String input) {
//        int[][] grid = new int[SIZE][SIZE];
//        String[] rows = input.trim().split("\n");
//        for (int i = 0; i < SIZE; i++) {
//            String[] cells = rows[i].trim().split(" ");
//            for (int j = 0; j < SIZE; j++) {
//                grid[i][j] = Integer.parseInt(cells[j]);
//            }
//        }
//        return grid;
//    }
//    // giải để tìm đáp án
//    public boolean solve() {
//
//        return solveCell(0, 0);
//    }
//
//    public boolean solveCell(int row, int col) {
//        if (row == SIZE) {
//            return true;
//        }
//        if (Grid[row][col] != 0) {
//            return solveNextCell(row, col);
//        }
//        for (int num = 1; num <= SIZE; num++) {
//            if (isValid(row, col, num)) {
//                Grid[row][col] = num;
//                if (solveNextCell(row, col)) {
//                    return true;
//                }
//                Grid[row][col] = 0;
//            }
//        }
//        return false;
//    }
//
//    public boolean solveNextCell(int row, int col) {
//        if (col == SIZE - 1) {
//            return solveCell(row + 1, 0);
//        } else {
//            return solveCell(row, col + 1);
//        }
//    }
//
//    public static boolean isValid(int row, int col, int num) {
//        for (int i = 0; i < SIZE; i++) {
//            if (Grid[row][i] == num)
//                return false;
//        }
//        for (int i = 0; i < SIZE; i++) {
//            if (Grid[i][col] == num)
//                return false;
//        }
//        int startRow = row - row % 3;
//        int startCol = col - col % 3;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (Grid[startRow + i][startCol + j] == num)
//                    return false;
//            }
//        }
//        return true;
//    }
//}
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuTest {
    private static final int BOARD_SIZE = 9;
    private static final int SUBGRID_SIZE = 3;

    public static void main(String[] args) {
        int[][] sudokuBoard = generateRandomSudoku();
        printBoard(sudokuBoard);
    }

    public static int[][] generateRandomSudoku() {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        solveSudoku(board);
        removeCells(board);
        return board;
    }

    public static void solveSudoku(int[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    public static boolean solveSudokuHelper(int[][] board, int row, int col) {
        if (col == BOARD_SIZE) {
            col = 0;
            row++;
            if (row == BOARD_SIZE) {
                return true; // Sudoku solved
            }
        }

        if (board[row][col] != 0) {
            return solveSudokuHelper(board, row, col + 1);
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(numbers);

        for (int num : numbers) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;

                if (solveSudokuHelper(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Check num in row
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check num in column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check num in subgrid
        int subgridStartRow = row - row % SUBGRID_SIZE;
        int subgridStartCol = col - col % SUBGRID_SIZE;

        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                if (board[subgridStartRow + i][subgridStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void removeCells(int[][] board) {
        int numCellsToRemove = (int) (Math.random() * 21) + 40; // Randomly remove 40-60 cells

        for (int i = 0; i < numCellsToRemove; i++) {
            int row = (int) (Math.random() * BOARD_SIZE);
            int col = (int) (Math.random() * BOARD_SIZE);

            if (board[row][col] != 0) {
                board[row][col] = 0;
            } else {
                i--;
            }
        }
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}