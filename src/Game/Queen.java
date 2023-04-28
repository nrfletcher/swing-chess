package Game;

public class Queen implements Piece {

    private final String color;

    public Queen(String color) {
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
        return "QUEEN";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }
}
