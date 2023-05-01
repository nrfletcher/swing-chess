package Game;

import java.util.ArrayList;

public class Empty implements Piece {

    public Empty() {
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
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
