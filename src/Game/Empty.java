package Game;

public class Empty implements Piece {

    public Empty() {
    }

    @Override
    public int[][] getLegalMoves() {
        return null;
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "EMPTY";
    }

    @Override
    public String getPieceColor() {
        return "NULL";
    }
}
