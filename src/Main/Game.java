package Main;

import Controller.ChessController;
import Graphics.BoardView;
import Game.BoardStatus;

public class Game {

    public static void main(String[] args) {

        BoardStatus boardStatus = new BoardStatus();
        BoardView boardView = new BoardView();
        ChessController chessController = new ChessController(boardStatus, boardView);
        boardView.setChessController(chessController);

    }
}
