package Graphics;

import Game.Move;
import Game.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*  ChessBoard is our visual chess board representation
 *  Complex logic warranted a separate class
 *  Initially the boardStatus is sent to a chessBoard on program launch
 *  For each user action resulting in a moved piece, a new board is created and updated onto GUI
 *  @author nrileyfletcher
 *  @brief  Handling changes in BoardView
 */

public class ChessBoard extends JPanel {

    private static final Color LIGHT_SQUARE_COLOR = new Color(163, 214, 245);
    private static final Color DARK_SQUARE_COLOR = new Color(102, 167, 197);
    private static final Color BACKGROUND_COLOR = new Color(110, 160, 205);
    private static final Color VALID_MOVE_COLOR = new Color(255, 60, 60, 147);
    private ActionListener buttonListener;

    private Piece[][] currentGameBoard;
    private JButton[][] boardButtons;
    private ArrayList<Move> validMoves;

    public ChessBoard(Piece[][] currentGameBoard, ArrayList<Move> validMoves) {
        this.validMoves = validMoves;
        this.currentGameBoard = currentGameBoard;
        this.boardButtons = new JButton[8][8];
        setPreferredSize(new Dimension(700, 700));
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

                // New button for each position -> add event handler
                JButton button = new JButton();

                // Painting board background
                if ((row + col) % 2 == 0) {
                    button.setBackground(LIGHT_SQUARE_COLOR);
                } else {
                    button.setBackground(DARK_SQUARE_COLOR);
                }

                /* Remove this after testing */
                if(validMoves != null && !validMoves.isEmpty()) {
                    for(Move move : validMoves) {
                        if(row == move.getX() && col == move.getY()) {
                            button.removeAll();
                            button.repaint();
                            button.setBackground(VALID_MOVE_COLOR);
                        }
                    }
                }

                try {
                    try {
                        // Get color and type of given position and find image
                        String pieceColor = currentGameBoard[row][col].getPieceColor().toLowerCase();
                        String pieceType = currentGameBoard[row][col].getPieceType().toLowerCase();

                        if(pieceType.equals("empty")) {
                            // For empty, just paint - no image (transparent)
                            button.setBorderPainted(false);
                        } else {
                            Image img = ImageIO.read(new File("images/" + pieceColor + "_" + pieceType +".png"));
                            button.setIcon(new ImageIcon(img));
                            button.setBorderPainted(false);
                        }

                        this.add(button);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }

                button.setBounds(col * squareSize, row * squareSize, squareSize, squareSize);
                /* Add our listener (same listener for all values, and set coordinate, so we can find button */
                button.addActionListener(buttonListener);
                button.setName(row + " " + col);
                boardButtons[row][col] = button;
            }
        }
    }

    public JLabel paintImage() throws IOException {
        BufferedImage image = ImageIO.read(new File("images/black_bishop.png"));
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }

    public JButton[][] getBoardButtons() {
        return this.boardButtons;
    }

    public void setButtonListener(ActionListener actionListener) {
        this.buttonListener = actionListener;
    }

    public void setValidMoves(ArrayList<Move> moves) {
        this.validMoves = moves;
    }

    public void setBoard(Piece[][] currentGameBoard) {
        this.currentGameBoard = currentGameBoard;
    }
}
