package Game;

public class Knight implements Piece {

    private final String color;

    public Knight(String color) {
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
        return "KNIGHT";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }
}
