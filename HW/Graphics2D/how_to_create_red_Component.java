package Graphics2D;

import javax.swing.*;
import java.awt.*;

public class how_to_create_red_Component extends JPanel {
    private static final int width = 800;
    private static final int length = 600;
    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.RED);
      g.fillRect(100, 100, 50, 50);
  }
  @Override
    public Dimension getPreferredSize(){
        return new Dimension(width, length);
  }
  public static void main(String[] args){
        JFrame frame = new JFrame("Simple Game Graphics");
      how_to_create_red_Component gameGraphics = new how_to_create_red_Component();
      frame.getContentPane().add(gameGraphics);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  }

}
