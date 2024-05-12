import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDrawingExample extends JPanel {

    private BufferedImage image;

    public ImageDrawingExample() {
        try {
            // Load the image from a file
            image = ImageIO.read(new File("C:\\Users\\Admin\\Downloads\\Pikachu Png Transparent Image - Pikachu Png, Png Download , Transparent Png Image - PNGitem.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the background color to blue
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Specify the scaling factor
        double scaleFactor = 0.3; // Decrease the size by 70%

        // Calculate the new width and height
        int newWidth = (int) (image.getWidth() * scaleFactor);
        int newHeight = (int) (image.getHeight() * scaleFactor);

        // Draw the scaled image at position (x, y)
        int x = 100;
        int y = 100;
        g.drawImage(image, x, y, newWidth, newHeight, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageDrawingExample panel = new ImageDrawingExample();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}