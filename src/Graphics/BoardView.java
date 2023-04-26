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
    JPanel scoreHolder;
    JLabel movesLabel;
    JScrollPane moveTable;
    JButton endGameButton;
    JPanel leftSidePanel;

    JLabel currentTurnLabel;
    JPanel chessBoard;
    JPanel rightSidePanel;

    public BoardView() {

        scoreLabel = createScoreLabel();
        whiteScore = createWhiteScoreLabel();
        blackScore = createBlackScoreLabel();
        moveTable = createMovesTable();
        movesLabel = createMovesLabel();
        endGameButton = createEndGameButton();
        currentTurnLabel = createTurnLabel();
        chessBoard = new ChessBoard();
        scoreHolder = new JPanel(new GridLayout());
        scoreHolder.add(whiteScore);
        scoreHolder.add(blackScore);

        leftSidePanel = new JPanel();
        leftSidePanel.add(chessBoard);
        this.add(leftSidePanel);

        this.setTitle("Title");
        this.setSize(1400, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void add(JPanel panel, JComponent comp, int x, int y, int width, int height) {
        /*  Gridbag constrains
         *  gridx -> column of component
         *  gridy -> row of component
         *  gridwidth -> number of columns component spans
         *  gridheight -> number of rows component spans
         *  fill -> constant for remaining space
         *  anchor -> determines where to place if no fill
         *  Insets -> padding around a component
         */
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(2, 2, 2, 2);
        constr.anchor = GridBagConstraints.CENTER;
        constr.fill = GridBagConstraints.BOTH;
        panel.add(comp, constr);
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

    public JScrollPane createMovesTable() {
        JScrollPane scrollPane;
        String[][] data = { {"",""},
                };
        String[] column = {"White","Black"};
        JTable table = new JTable(data, column);
        scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    public JLabel createMovesLabel() {
        JLabel label = new JLabel("Moves");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        return label;
    }

    public JButton createEndGameButton() {
        JButton button = new JButton("End Game");
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Georgia", Font.BOLD, 30));
        button.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        return button;
    }

    public JLabel createTurnLabel() {
        JLabel label = new JLabel("Current Turn: NULL");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        return label;
    }

}
