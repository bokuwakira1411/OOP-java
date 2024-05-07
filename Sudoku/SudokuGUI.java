package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class SudokuGUI extends JPanel implements ActionListener {
    private static int[][] Grid;
    private static int[][] grid;
    private static JFrame frame;
    public static JButton New, End, Easy, Medium, Hard;
    private static GameMenu gameMenu;
    // Thêm static và chuyển thành biến thành viên
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    public static void main(String[] args) {
        SudokuSolve sudoku = new SudokuSolve();
        Grid = sudoku.generateRandomSudoku();
        grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Grid[i][j];
            }
        }
        frame = new JFrame("Sudoku");
        gameMenu = new GameMenu(frame, Grid);
        gameMenu.createFrame();
    }

    public static void openGame(int n) {
        Random random = new Random();
        int count = 0;
        while (count < n) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (Grid[row][col] != 0) {
                Grid[row][col] = 0;
                count++;
            }
        }
    }
    public static void checkValue(JFormattedTextField[][] cells, int row, int col) {
        JFormattedTextField textField = cells[row][col];
        String value = textField.getText();
        String expectedValue = String.valueOf(grid[row][col]); // Giả sử Grid là một mảng chứa các giá trị dự kiến
        if (!value.equals(expectedValue)) {
            textField.setForeground(Color.RED);
            // Thêm mã xử lý ở đây để xử lý việc kết thúc trò chơi hoặc bất kỳ hành động mong muốn khác
        } else {
            textField.setForeground(Color.GREEN);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
