package Graphics;

import Game.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*  BoardView is the view in the MVC architecture
 *  All visuals are updated and created here
 *  We extend JFrame to allow our BoardView to act as a JFrame
 */

public class BoardView extends JFrame {

    private final Color lightBlue = new Color(163, 214, 245);
    private final Color darkBlue = new Color(102, 167, 197);
    private final Color backgroundColor = new Color(110, 160, 205);

    JLabel scoreLabel;
    JLabel whiteScore;
    JLabel blackScore;
    JLabel movesLabel;
    JScrollPane moveTable;
    JButton endGameButton;

    JLabel currentTurnLabel;
    ChessBoard chessBoard;
    JPanel gamePanel;

    public BoardView(ChessBoard chessBoard) {

        scoreLabel = createScoreLabel();
        whiteScore = createWhiteScoreLabel();
        blackScore = createBlackScoreLabel();
        moveTable = createMovesTable();
        movesLabel = createMovesLabel();
        endGameButton = createEndGameButton();
        currentTurnLabel = createTurnLabel();
        this.chessBoard = chessBoard;
        this.chessBoard.setBackground(backgroundColor);

        // add -> panel, component, x, y, width, height
        gamePanel = new JPanel(new GridBagLayout());
        gamePanel.setBackground(backgroundColor);

        add(gamePanel, scoreLabel, 0, 0, 1, 1, 10);
        add(gamePanel, whiteScore, 0, 1, 1, 1, 10);
        add(gamePanel, blackScore, 0, 2, 1, 1, 10);
        add(gamePanel, moveTable, 0, 4, 1, 1, 10);
        add(gamePanel, movesLabel, 0, 3, 1, 1, 10);
        add(gamePanel, endGameButton, 0, 5, 1, 1, 10);
        add(gamePanel, currentTurnLabel, 1, 0, 1, 1, 50);
        addChessBoard(gamePanel, chessBoard, 1, 1, 5, 5);
        this.add(gamePanel);

        this.setTitle("Blue Chess");
        this.setSize(1400, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void add(JPanel panel, JComponent comp, int x, int y, int width, int height, int inset) {
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
        constr.insets = new Insets(inset, inset, inset, inset);
        constr.anchor = GridBagConstraints.CENTER;
        constr.fill = GridBagConstraints.BOTH;
        constr.ipadx = 15;
        constr.ipady = 15;
        panel.add(comp, constr);
    }

    public static void addChessBoard(JPanel panel, JComponent comp, int x, int y, int width, int height) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(50, 50, 50, 50);
        constr.anchor = GridBagConstraints.CENTER;
        constr.fill = GridBagConstraints.BOTH;
        panel.add(comp, constr);
    }

    public JLabel createScoreLabel() {
        JLabel label = new JLabel("Scores");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(lightBlue);
        label.setOpaque(true);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public JLabel createWhiteScoreLabel() {
        JLabel label = new JLabel("White Score: ");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(lightBlue);
        label.setOpaque(true);
        return label;
    }

    public JLabel createBlackScoreLabel() {
        JLabel label = new JLabel("Black Score: ");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(lightBlue);
        label.setOpaque(true);
        return label;
    }

    public JScrollPane createMovesTable() {
        JScrollPane scrollPane;
        String[][] data = { {"",""},
                };
        String[] column = {"White","Black"};
        JTable table = new JTable(data, column);
        table.setFont(new Font("Georgia", Font.BOLD, 20));
        table.setBackground(darkBlue);
        table.setForeground(darkBlue);
        table.setGridColor(darkBlue);
        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(darkBlue);
        scrollPane.setFont(new Font("Georgia", Font.BOLD, 20));
        return scrollPane;
    }

    public JLabel createMovesLabel() {
        JLabel label = new JLabel("Moves");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(lightBlue);
        label.setOpaque(true);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public JButton createEndGameButton() {
        JButton button = new JButton("End Game");
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Georgia", Font.BOLD, 30));
        button.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        button.setBackground(lightBlue);
        button.setOpaque(true);
        return button;
    }

    public JLabel createTurnLabel() {
        JLabel label = new JLabel("Current Turn: NULL");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(lightBlue);
        label.setOpaque(true);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public void setCurrentBoardStatus(Piece[][] board) {
        this.chessBoard = new ChessBoard(board);
    }

    public ChessBoard getCurrentBoardStatus() {
        return this.chessBoard;
    }

    public void setCurrentTurnLabel(String turn) {
        this.currentTurnLabel.setText("Current Turn: " + turn);
    }

    public void setCurrentBlackScore(int score) {
        this.whiteScore.setText("White Score: " + score);
    }

    public void setCurrentWhiteScore(int score) {
        this.blackScore.setText("Black Score: " + score);
    }

    public void setFrameIcon() throws IOException {
        BufferedImage image = ImageIO.read(new File("images/black_bishop.png"));
        ImageIcon icon = new ImageIcon(image);
        this.setIconImage(icon.getImage());
    }
}
