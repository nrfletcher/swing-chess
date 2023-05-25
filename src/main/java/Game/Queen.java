package Game;

import Utils.DiagonalCheck;
import Utils.HorizontalCheck;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief Queen piece implementation
 */
public class Queen implements Piece {

    private final String color;

    public Queen(String color) {
        this.color = color;
    }

    /* Utilize Rook + Bishop legal moves for queen */
    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        HorizontalCheck horizontalCheck = new HorizontalCheck(currentBoard, row, col);
        DiagonalCheck diagonalCheck = new DiagonalCheck(currentBoard, row, col);
        ArrayList<Move> horizontalMoves = horizontalCheck.getLegalHorizontalMoves();
        ArrayList<Move> diagonalMoves = diagonalCheck.getLegalDiagonalMoves();
        horizontalMoves.removeAll(diagonalMoves);
        horizontalMoves.addAll(diagonalMoves);
        return horizontalMoves;
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "QUEEN";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }

    @Override
    public boolean moveInBounds(Move move) {
        return move.getY() <= 7 && move.getY() >= 0 && move.getX() <= 7 && move.getX() >= 0;
    }
}
