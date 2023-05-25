package Game;

import Utils.DiagonalCheck;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief Bishop piece implementation
 */
public class Bishop implements Piece {

    private final String color;

    public Bishop(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        DiagonalCheck diagonalCheck = new DiagonalCheck(currentBoard, row, col);
        return diagonalCheck.getLegalDiagonalMoves();
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "BISHOP";
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
