package Graphics2D;
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class how_to_click_drag_picture extends JPanel {

    private Image image;
    private int imageX;
    private int imageY;
    private int mouseX;
    private int mouseY;
    private boolean isDragging;

    public how_to_click_drag_picture() {
        // Load the image from a file
        image = new ImageIcon("C:\\Users\\Admin\\Downloads\\Pikachu Png Transparent Image - Pikachu Png, Png Download , Transparent Png Image - PNGitem.jpg").getImage();

        // Set initial position of the image
        imageX = 100;
        imageY = 100;

        // Add mouse listeners
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                if (mouseX >= imageX && mouseX < imageX + image.getWidth(null)
                        && mouseY >= imageY && mouseY < imageY + image.getHeight(null)) {
                    isDragging = true;
                }
            }

            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    int dx = e.getX() - mouseX;
                    int dy = e.getY() - mouseY;
                    imageX += dx;
                    imageY += dy;
                    mouseX += dx;
                    mouseY += dy;
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image at the specified position (imageX, imageY)
        g.drawImage(image, imageX, imageY, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Drawing Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            how_to_click_drag_picture panel = new how_to_click_drag_picture();
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}