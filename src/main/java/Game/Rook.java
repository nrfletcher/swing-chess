package Game;

import Utils.HorizontalCheck;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief Rook piece implementation
 */
public class Rook implements Piece {

    private final String color;

    public Rook(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        HorizontalCheck horizontalCheck = new HorizontalCheck(currentBoard, row, col);
        return horizontalCheck.getLegalHorizontalMoves();
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "ROOK";
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
