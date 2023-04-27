package Game;

public class Queen implements Piece {

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
        return null;
    }

    @Override
    public String getPieceColor() {
        return null;
    }
}
