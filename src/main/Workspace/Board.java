package Workspace;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Board {
    JFrame f;
    Board (){
        JPanel jPanel = new JPanel(new GridLayout(3, 1));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 3));
        f=new JFrame();
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        try {
            Image img = ImageIO.read(new File("images/black_bishop.png"));
            b3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
        JButton b8=new JButton("8");
        JButton b9=new JButton("9");
        // adding buttons to the frame
        jPanel.add(b1);
        jPanel.add(b3);
        jPanel.add(b5);
        jPanel2.add(b7);

        // setting grid layout of 3 rows and 3 columns
        f.setLayout(new GridLayout(1, 2));
        f.add(jPanel);
        f.add(jPanel2);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Board();
    }

    public void initializeBoard() {
        // Set up the size of the chess board
        //int width = getWidth();
        //int height = getHeight();
        //int squareSize = Math.min(width, height) / 8;


        // Draw the chess board squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton();
                if ((row + col) % 2 == 0) {
                    //button.setBackground(lightSquareColor);
                } else {
                    //button.setBackground(darkSquareColor);
                }

                //button.setBounds(col * squareSize, row * squareSize, squareSize, squareSize);
                try {
                    Image img = ImageIO.read(new File("images/black_bishop.png"));
                    button.setIcon(new ImageIcon(img));
                    button.setBorderPainted(false);
                    button.setBackground(Color.GREEN);

                    //this.add(button);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
