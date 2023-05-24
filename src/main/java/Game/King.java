package Game;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief King piece implementation
 */
public class King implements Piece {

    private final String color;

    public King(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        ArrayList<Move> legalMoves = new ArrayList<>();
        String color = currentBoard[row][col].getPieceColor();

        if(color.equalsIgnoreCase("black")) {
            if(currentBoard[row + 1][col + 1].
                    getPieceColor().
                    equalsIgnoreCase("white")) legalMoves.add(new Move(row + 1, col + 1));
            if(currentBoard[row + 1][col - 1].
                    getPieceColor().
                    equalsIgnoreCase("white")) legalMoves.add(new Move(row + 1, col - 1));
            if(row == 1) {
                if(currentBoard[row + 2][col].
                        getPieceColor().
                        equalsIgnoreCase("null")) legalMoves.add(new Move(row + 2, col));
            }
            if(currentBoard[row + 1][col].
                    getPieceColor().
                    equalsIgnoreCase("null")) legalMoves.add(new Move(row + 1, col));
        } else {
            if(currentBoard[row - 1][col - 1].
                    getPieceColor().
                    equalsIgnoreCase("black")) legalMoves.add(new Move(row - 1, col - 1));
            if(currentBoard[row - 1][col + 1].
                    getPieceColor().
                    equalsIgnoreCase("black")) legalMoves.add(new Move(row - 1, col + 1));
            if(row == 6) {
                if(currentBoard[row - 2][col].
                        getPieceColor().
                        equalsIgnoreCase("null")) legalMoves.add(new Move(row - 2, col));
            }
            if(currentBoard[row - 1][col].
                    getPieceColor().
                    equalsIgnoreCase("null")) legalMoves.add(new Move(row - 1, col));
        }

        return legalMoves;
    }

    @Override
    public int getPieceValue() {
        return 0;
    }

    @Override
    public String getPieceType() {
        return "KING";
    }

    @Override
    public String getPieceColor() {
        return this.color;
    }

    @Override
    public boolean moveInBounds(Move move) {
        return false;
    }
}
