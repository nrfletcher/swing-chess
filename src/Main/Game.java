package Main;

import Controller.ChessController;
import Graphics.BoardView;
import Game.Board;

public class Game {

    public static void main(String[] args) {

        Board boardStatus = new Board();
        BoardView boardView = new BoardView();
        ChessController chessController = new ChessController(boardStatus, boardView);

    }
}
