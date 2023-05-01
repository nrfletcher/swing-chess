package Game;

import java.util.ArrayList;

public class Bishop implements Piece {

    private final String color;

    public Bishop(String color) {
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
        return "BISHOP";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }
}
