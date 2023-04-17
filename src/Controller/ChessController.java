package Controller;

import Game.BoardStatus;
import Graphics.BoardView;

public class ChessController {

    private BoardView boardView;
    private BoardStatus boardStatus;

    public ChessController(BoardStatus boardStatus, BoardView boardView) {
        this.boardStatus = boardStatus;
        this.boardView = boardView;
    }

    public void buttonHandler() {
        boardView.setButtonText();
    }

}
