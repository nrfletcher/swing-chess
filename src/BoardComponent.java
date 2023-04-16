import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JComponent {

    private final int SQUARE_SIZE = 50; // size of each square in pixels
    private final int BOARD_SIZE = SQUARE_SIZE * 8; // size of the board in pixels

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int x = col * SQUARE_SIZE;
                int y = row * SQUARE_SIZE;

                if ((row + col) % 2 == 0) {
                    g2d.setColor(Color.WHITE);
                } else {
                    g2d.setColor(Color.BLACK);
                }

                g2d.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle("Board Example");
        frame.add(new BoardComponent());
        frame.setVisible(true);
    }
}