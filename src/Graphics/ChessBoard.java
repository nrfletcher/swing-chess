package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChessBoard extends JPanel {

    private final Color lightSquareColor = new Color(163, 214, 245);
    private final Color darkSquareColor = new Color(102, 167, 197);

    ChessBoard() {
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Set up the size of the chess board
        int width = getWidth();
        int height = getHeight();
        int squareSize = Math.min(width, height) / 8;


        // Draw the chess board squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton();
                if ((row + col) % 2 == 0) {
                    button.setBackground(lightSquareColor);
                } else {
                    button.setBackground(darkSquareColor);
                }

                button.setBounds(col * squareSize, row * squareSize, squareSize, squareSize);
                try {
                    Image img = ImageIO.read(new File("images/black_bishop.png"));
                    button.setIcon(new ImageIcon(img));
                    button.setBorderPainted(false);
                    this.add(button);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public JLabel paintImage() throws IOException {
        BufferedImage image = ImageIO.read(new File("images/black_bishop.png"));
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }
}
