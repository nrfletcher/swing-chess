package Game;

import java.util.ArrayList;

public class Rook implements Piece {

    private final String color;

    public Rook(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        ArrayList<Move> legalMoves = new ArrayList<>();
        return legalMoves;
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
}
