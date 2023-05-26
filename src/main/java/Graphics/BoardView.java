package Graphics;

import Game.Move;
import Game.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*  BoardView is the view in the MVC architecture
 *  All visuals are updated and created here
 *  We extend JFrame to allow our BoardView to act as a JFrame
 *  @author nrileyfletcher
 *  @brief Graphical representation of chess board
 */

public class BoardView extends JFrame {

    private static final Color LIGHT_BLUE = new Color(163, 214, 245);
    private static final Color DARK_BLUE = new Color(102, 167, 197);
    private static final Color BACKGROUND_COLOR = new Color(110, 160, 205);

    JLabel scoreLabel;
    JLabel whiteScore;
    JLabel blackScore;
    JLabel movesLabel;
    JScrollPane moveTable;
    JButton endGameButton;
    JLabel currentTurnLabel;
    ChessBoard chessBoard;
    JPanel gamePanel;
    JTable table;
    DefaultTableModel defaultTableModel;

    public BoardView(ChessBoard chessBoard) {

        scoreLabel = createScoreLabel();
        whiteScore = createWhiteScoreLabel();
        blackScore = createBlackScoreLabel();
        moveTable = createMovesTable();
        movesLabel = createMovesLabel();
        endGameButton = createEndGameButton();
        currentTurnLabel = createTurnLabel();
        this.chessBoard = chessBoard;
        this.chessBoard.setBackground(BACKGROUND_COLOR);

        gamePanel = new JPanel(new GridBagLayout());
        gamePanel.setBackground(BACKGROUND_COLOR);

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
        label.setBackground(LIGHT_BLUE);
        label.setOpaque(true);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public JLabel createWhiteScoreLabel() {
        JLabel label = new JLabel("White Score: ");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(LIGHT_BLUE);
        label.setOpaque(true);
        return label;
    }

    public JLabel createBlackScoreLabel() {
        JLabel label = new JLabel("Black Score: ");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(LIGHT_BLUE);
        label.setOpaque(true);
        return label;
    }

    public JScrollPane createMovesTable() {
        JScrollPane scrollPane;
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("White");
        defaultTableModel.addColumn("Black");
        table = new JTable(defaultTableModel);
        table.setBackground(DARK_BLUE);
        table.setGridColor(DARK_BLUE);
        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(DARK_BLUE);
        scrollPane.setFont(new Font("Georgia", Font.BOLD, 20));
        return scrollPane;
    }

    public JLabel createMovesLabel() {
        JLabel label = new JLabel("Moves");
        label.setFont(new Font("Georgia", Font.BOLD, 45));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(LIGHT_BLUE);
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
        button.setBackground(LIGHT_BLUE);
        button.setOpaque(true);
        return button;
    }

    public JLabel createTurnLabel() {
        JLabel label = new JLabel("Current Turn: NULL");
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        label.setForeground(Color.getHSBColor(0.66f, 1.0f, 0.2f));
        label.setBackground(LIGHT_BLUE);
        label.setOpaque(true);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public void setCurrentBoardStatus(Piece[][] board, ArrayList<Move> moves) {
        this.chessBoard.setBoard(board);
        this.chessBoard.setValidMoves(moves);
        this.chessBoard.removeAll();
        this.chessBoard.repaint();
        this.chessBoard.validate();
    }

    public void displayValidMoves(Piece[][] board, ArrayList<Move> validMoves) {
        this.chessBoard.setValidMoves(validMoves);
        this.chessBoard.removeAll();
        this.chessBoard = new ChessBoard(board, validMoves);
        validate();
        repaint();
    }

    public void addMoveToTable(Piece piece, Move move) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String data = piece.getPieceType();

        String[] values = {"A", "B", "C", "D", "E", "F", "G"};
        String x = Integer.toString(move.getX());
        String y = values[move.getY()];
        String[] input;

        if(piece.getPieceColor().equalsIgnoreCase("white")) {
            input = new String[]{data + " " + y + " " + x, ""};

        } else {
            input = new String[]{"", data + " " + y + " " + x};
        }
        model.addRow(input);
        repaint();
    }

    public void resetMoveTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public void createEndGamePopup() {
        JOptionPane.showMessageDialog(null, "Game Over");
    }

    public ChessBoard getCurrentBoardStatus() {
        return this.chessBoard;
    }

    public void setCurrentTurnLabel(String turn) {
        this.currentTurnLabel.setText("Current Turn: " + turn);
    }

    public void setCurrentBlackScore(int score) {
        System.out.println(score);
        this.whiteScore.setText("White Score: " + score);
    }

    public void setCurrentWhiteScore(int score) {
        System.out.println(score);
        this.blackScore.setText("Black Score: " + score);
    }

    public void setFrameIcon() throws IOException {
        BufferedImage image = ImageIO.read(new File("images/black_bishop.png"));
        ImageIcon icon = new ImageIcon(image);
        this.setIconImage(icon.getImage());
    }
}
