package Game;

public class Rook implements Piece {

    private final String color;

    public Rook(String color) {
        this.color = color;
    }

    @Override
    public int[][] getLegalMoves() {
        return new int[0][];
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
