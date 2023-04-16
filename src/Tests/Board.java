package Tests;

import javax.swing.*;
import java.awt.*;

public class Board {

    JFrame board = new JFrame();

    public Board() {
        board.setSize(1000, 1000);
        board.setTitle("Chess");
        board.setLayout(null);
        board.setVisible(true);
        board.setLocationRelativeTo(null);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addButton() {
        JButton button = new JButton("Tests");
        button.setBounds(100, 100, 100, 100);
        board.add(button);
    }

    public void drawBoard() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(100, 50, 50, 50);
    }

}
