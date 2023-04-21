package Controller;

/* ChessController allows the Board and BoardView to work together without interacting
 * When an event occurs, ChessController sees it happen
 * Once this event occurs, it acts on the Board or BoardView as necessary
 */

import Game.Board;
import Graphics.BoardView;

public class ChessController {


    private BoardView boardView;
    private Board boardStatus;

    public ChessController(Board boardStatus, BoardView boardView) {
        this.boardStatus = boardStatus;
        this.boardView = boardView;
    }

    public void buttonHandler() {
        //boardView.setButtonText();
    }

}
