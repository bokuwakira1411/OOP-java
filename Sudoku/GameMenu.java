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

import static Sudoku.SudokuGUI.openGame;
public class GameMenu {
    public static JButton New, End, Easy, Medium, Hard;
    private static JFrame frame;
    private static int[][] Grid;
    public static JFormattedTextField[][] cells;
    public GameMenu(JFrame frame, int[][] Grid){
        this.frame = frame;
        this.Grid = Grid;
    }
    public void createFrame(){
        //create Buttons
    New = new JButton("New");
    End = new JButton("End");
    Easy = new JButton("Easy");
    Medium = new JButton("Medium");
    Hard = new JButton("Hard");
    // create Frame
    frame = new JFrame("SUDOKU");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.revalidate();
    frame.repaint();
    // create JPanel - button - level
    JPanel button = new JPanel();
    button.setLayout(new FlowLayout(FlowLayout.LEFT));
    button.add(New);
    button.add(End);
    JPanel level = new JPanel();
    level.add(Easy);
    level.add(Medium);
    level.add(Hard);
    Color color = new Color(255, 255, 255);
    // setVisibleLevel
    Easy.setVisible(false);
    Medium.setVisible(false);
    Hard.setVisible(false);
    // setColor
    Easy.setBackground(color);
    Medium.setBackground(color);
    Hard.setBackground(color);
    New.setBackground(color);
    End.setBackground(color);
    //setLayout
    level.setLayout(new FlowLayout());
    frame.add(button, BorderLayout.NORTH);
    frame.add(level, BorderLayout.CENTER);
    frame.getContentPane().setBackground(Color.PINK);
    //addActionForButtons
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
    public static void set(int n){
        createMatrix();
        openGame(n);
        addNumber(Grid);
        New.setVisible(true);
        End.setVisible(true);
        Easy.setVisible(false);
        Medium.setVisible(false);
        Hard.setVisible(false);
    }
    public static void addNumber(int[][] Grid) {
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
                        SudokuGUI.checkValue(cells, row, col);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        SudokuGUI.checkValue(cells, row, col);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        SudokuGUI.checkValue(cells, row, col);
                    }
                });
            }}
    }
}
