package Main;

import Controller.ChessController;
import Game.Board;
import Graphics.BoardView;
import Graphics.ChessBoard;

/*  Game class is the origin for a new game
 *  When launched, all values and piece positions are set to game begin
 */

public class Game {

    public static void main(String[] args) {

        Board boardStatus = new Board();
        BoardView boardView = new BoardView(new ChessBoard(boardStatus.getCurrentBoardStatus()));
        ChessController chessController = new ChessController(boardStatus, boardView);

    }
}
