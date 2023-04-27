package Game;

public class King implements Piece {

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
