package Game;

public class Bishop implements Piece {

    private final String color;

    public Bishop(String color) {
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
        return "BISHOP";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }
}
