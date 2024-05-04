package Sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuSolve {

        private static final int SIZE = 9;
        public static int[][] generateRandomSudoku() {
            int[][] Grid = new int[9][9];
            solveSudoku(Grid);
            return Grid;
        }

        public static void solveSudoku(int[][] Grid) {
            solveSudokuHelper(Grid, 0, 0);
        }

        public static boolean solveSudokuHelper(int[][] Grid, int row, int col) {
            if (col == 9) {
                col = 0;
                row++;
                if (row == 9) {
                    return true; // Sudoku solved
                }
            }

            if (Grid[row][col] != 0) {
                return solveSudokuHelper(Grid, row, col + 1);
            }

            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            Collections.shuffle(numbers);

            for (int num : numbers) {
                if (isValid(Grid, row, col, num)) {
                    Grid[row][col] = num;

                    if (solveSudokuHelper(Grid, row, col + 1)) {
                        return true;
                    }

                    Grid[row][col] = 0;
                }
            }

            return false;
        }
        public static boolean isValid(int[][] Grid,int row, int col, int num) {
            for (int i = 0; i < SIZE; i++) {
                if (Grid[row][i] == num)
                    return false;
            }
            for (int i = 0; i < SIZE; i++) {
                if (Grid[i][col] == num)
                    return false;
            }
            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Grid[startRow + i][startCol + j] == num)
                        return false;
                }
            }
            return true;
        }

    }
