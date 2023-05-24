package Game;

/*  Interface defines a contract that all piece types must follow
 *  All pieces must provide functions for accessing legal moves, value, and name
 *  @author nrileyfletcher
 *  @brief Base class for all pieces
 */

import java.util.ArrayList;

public interface Piece {
    ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col);
    int getPieceValue();
    String getPieceType();
    String getPieceColor();
    boolean moveInBounds(Move move);
}
