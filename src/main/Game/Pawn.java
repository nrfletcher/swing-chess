package Game;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief Pawn piece implementation
 */
public class Pawn implements Piece {

    private final String color;

    public Pawn(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        ArrayList<Move> legalMoves = new ArrayList<>();


        /* For testing purposes - remove after final product */
        legalMoves.add(new Move(0, 3));

        return legalMoves;
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "PAWN";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }
}
