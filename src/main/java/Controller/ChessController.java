package Controller;

import Game.Board;
import Game.Empty;
import Game.Move;
import Game.Piece;
import Graphics.BoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* ChessController allows the Board and BoardView to work together without interacting
 * When an event occurs, ChessController sees it happen
 * Once this event occurs, it acts on the Board or BoardView as necessary
 * @author nrileyfletcher
 * @brief  Interaction between graphic and logic board representations
 */

public class ChessController {

    private BoardView boardView;
    private Board boardStatus;

    public ChessController(Board boardStatus, BoardView boardView) {
        this.boardStatus = boardStatus;
        this.boardView = boardView;
        this.boardView.setCurrentTurnLabel(boardStatus.getCurrentTurn());
        this.boardView.setCurrentBlackScore(boardStatus.getCurrentBlackScore());
        this.boardView.setCurrentWhiteScore(boardStatus.getCurrentWhiteScore());
        this.boardView.getCurrentBoardStatus().setButtonListener(new ButtonListener());
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /* Get our button row and column */
            JButton clickedButton = (JButton) e.getSource();
            String pos = clickedButton.getName();

            int row = Integer.parseInt(pos.split(" ")[0]);
            int col = Integer.parseInt(pos.split(" ")[1]);

            Piece piece = boardStatus.getCurrentBoardStatus()[row][col];
            String pieceType = boardStatus.getCurrentBoardStatus()[row][col].getPieceType();
            String pieceColor = boardStatus.getCurrentBoardStatus()[row][col].getPieceColor();

            System.out.println(row + " " + col);
            System.out.println("yo");

            if(boardStatus.getCurrentTurn().equalsIgnoreCase(pieceColor)) {
                System.out.println("Current color");
                boardStatus.setLastX(row);
                boardStatus.setLastY(col);
                boardStatus.setLastPieceType(piece);
                boardStatus.getValidMoves().clear();

                ArrayList<Move> legalMoves = boardStatus.
                        getCurrentBoardStatus()[row][col].
                        getLegalMoves(boardStatus.getCurrentBoardStatus(), row, col);

                for(Move move : legalMoves) {
                    boardStatus.getValidMoves().add(move);
                }

            } else if(boardStatus.isValidMove(new Move(row, col))) {
                System.out.println("Valid move occured");

                boardStatus.getCurrentBoardStatus()[boardStatus.getLastX()][boardStatus.getLastY()] = new Empty();
                boardStatus.getCurrentBoardStatus()[row][col] = boardStatus.getLastPieceType();
                boardStatus.getValidMoves().clear();
                boardView.setCurrentBoardStatus(boardStatus.getCurrentBoardStatus());
                boardStatus.setCurrentTurn("Black");
                boardView.setCurrentTurnLabel(boardStatus.getCurrentTurn());
            } else {
                System.out.println("Not our piece or valid move");
            }
        }
    }
}