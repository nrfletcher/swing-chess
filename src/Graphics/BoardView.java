package Graphics;

import javax.swing.*;
import java.awt.*;

/*  BoardView is the view in the MVC architecture
 *  All visuals are updated and created here
 *  We extend JFrame to allow our BoardView to act as a JFrame
 */

public class BoardView extends JFrame {

    JLabel scoreLabel;
    JLabel whiteScore;
    JLabel blackScore;
    JScrollPane scrollPane;
    JPanel scoreHolder;
    JLabel movesLabel;
    JTable moveTable;
    JButton endGameButton;
    JPanel leftSidePanel;

    JLabel currentTurnLabel;
    JLabel boardPlaceHolder;
    JPanel rightSidePanel;

    public BoardView() {

        scoreLabel = createScoreLabel();
        whiteScore = createWhiteScoreLabel();
        blackScore = createBlackScoreLabel();
        this.add(scoreLabel);
        this.add(whiteScore);
        this.add(blackScore);

        this.setTitle("Title");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public JLabel createScoreLabel() {
        JLabel label = new JLabel("Scores");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        return label;
    }

    public JLabel createWhiteScoreLabel() {
        JLabel label = new JLabel("White Score");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        return label;
    }

    public JLabel createBlackScoreLabel() {
        JLabel label = new JLabel("Black Score");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        return label;
    }

}
