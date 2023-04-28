package Game;

public class Pawn implements Piece {

    private final String color;

    public Pawn(String color) {
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
        return "PAWN";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }
}
