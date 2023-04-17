package Graphics;

import Controller.ChessController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardView extends JFrame {

    private JTextField textField;
    private JButton button;
    private ChessController chessController;

    public BoardView() {
        textField = new JTextField("Testing");
        button = new JButton("Click Me");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessController.buttonHandler();
            }
        });

        this.add(textField);
        this.add(button);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setChessController(ChessController chessController) {
        this.chessController = chessController;
    }

    public void setButtonText() {
        this.button.setText("Changed");
    }

}
