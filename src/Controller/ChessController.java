package Controller;

import Game.Board;
import Graphics.BoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* ChessController allows the Board and BoardView to work together without interacting
 * When an event occurs, ChessController sees it happen
 * Once this event occurs, it acts on the Board or BoardView as necessary
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
            String pieceType = boardStatus.getCurrentBoardStatus()[row][col].getPieceType();
            String pieceColor = boardStatus.getCurrentBoardStatus()[row][col].getPieceColor();

            if(boardStatus.getCurrentTurn().equalsIgnoreCase(pieceColor)) {

            } else {
                System.out.println("Incorrect Turn");
            }

        }
    }
}
