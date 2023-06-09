package Game;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief Empty board position
 */
public class Empty implements Piece {

    public Empty() {
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        return null;
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "EMPTY";
    }

    @Override
    public String getPieceColor() {
        return "NULL";
    }

    @Override
    public boolean moveInBounds(Move move) {
        return false;
    }
}
