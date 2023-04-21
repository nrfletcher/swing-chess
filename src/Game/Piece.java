package Game;

/*  Interface defines a contract that all piece types must follow
 *  All pieces must provide functions for accessing legal moves, value, and name
 */

public interface Piece {
    int[][] getLegalMoves();
    int getPieceValue();
    String getPieceName();
}
