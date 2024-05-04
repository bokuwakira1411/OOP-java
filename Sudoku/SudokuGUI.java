package Sudoku;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;
public class SudokuGUI extends JPanel implements ActionListener {
    private static int[][] Grid;
    private static int[][] grid;
    private static JFrame frame;
    public static JButton New, End, Easy, Medium, Hard;

    private static JFormattedTextField[][] cells; // Thêm static và chuyển thành biến thành viên
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
        createFrame();
    }

    public static void createFrame() {
        New = new JButton("New");
        End = new JButton("End");
        Easy = new JButton("Easy");
        Medium = new JButton("Medium");
        Hard = new JButton("Hard");
        frame = new JFrame("SUDOKU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.revalidate();
        frame.repaint();
        JPanel button = new JPanel();
        button.setLayout(new FlowLayout(FlowLayout.LEFT));
        button.add(New);
        button.add(End);
        JPanel level = new JPanel();
        level.add(Easy);
        level.add(Medium);
        level.add(Hard);
        Color color = new Color(255, 255, 255);
        Easy.setVisible(false);
        Medium.setVisible(false);
        Hard.setVisible(false);
        Easy.setBackground(color);
        Medium.setBackground(color);
        Hard.setBackground(color);
        New.setBackground(color);
        End.setBackground(color);
        frame.add(button, BorderLayout.NORTH);
        level.setLayout(new FlowLayout());
        frame.add(level, BorderLayout.CENTER);
        frame.getContentPane().setBackground(Color.PINK);
        End.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Easy.setVisible(true);
                Medium.setVisible(true);
                Hard.setVisible(true);
                New.setVisible(false);
                End.setVisible(false);
                Easy.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    int n = 45;
                    set(n);
                }
                });
                Medium.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = 55;
                        set(n);
                    }
                });
                Hard.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = 65;
                        set(n);
                    }
                });
            }
        });
        frame.setSize(700, 700);
        frame.setVisible(true);
    }
    public static void set(int n){
        createMatrix();
        openGame(n);
        addNumber();
        New.setVisible(true);
        End.setVisible(true);
        Easy.setVisible(false);
        Medium.setVisible(false);
        Hard.setVisible(false);
    }
    public static void createMatrix(){
    JPanel panel = new JPanel(new GridLayout(9, 9));
    cells = new JFormattedTextField[9][9]; // Thêm static
    NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(9);
        for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            JFormattedTextField cell = new JFormattedTextField(formatter);
            cell.setHorizontalAlignment(JTextField.CENTER);
            cell.setFont(new Font("Arial", Font.BOLD, 40));
            cells[i][j] = cell;
            int top = (i % 3 == 0) ? 5 : 1;
            int left = (j % 3 == 0) ? 5 : 1;
            int bottom = (i == 8) ? 5 : 1;
            int right = (j == 8) ? 5 : 1;
            cell.setBorder(new MatteBorder(top, left, bottom, right, Color.gray));
            panel.add(cell);
        }
    }
        frame.add(panel);
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

    public static void addNumber() {
        // In các số từ mảng Grid lên các ô
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = Grid[i][j];
                String text = (value != 0) ? String.valueOf(value) : "";
                cells[i][j].setText(text);
                final int row = i;
                final int col = j;
                cells[i][j].getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        checkValue(cells, row, col);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        checkValue(cells, row, col);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        checkValue(cells, row, col);
                    }
                });
            }}
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