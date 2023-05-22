package Game;

import java.util.ArrayList;
import java.util.Locale;

/* @author nrileyfletcher
 * @brief Pawn piece implementation
 */
public class Pawn implements Piece {

    private final String color;

    public Pawn(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        ArrayList<Move> legalMoves = new ArrayList<>();
        String color = currentBoard[row][col].getPieceColor();

        /* work on this 5/21 (legal pawn moves) (also from now on do this pseudo code style much easier)
        if(color.equalsIgnoreCase("black")) {
            if(row == 1) {
                if(currentBoard[row + 1][col].getPieceColor().equalsIgnoreCase("null")) legalMoves.add(new Move(row + 1, col));
                if(currentBoard[row + 2][col].getPieceColor().equalsIgnoreCase("null")) legalMoves.add(new Move(row + 2, col));
            } else {

            }
        } else {
            if(row == 6) {

            } else {
                if()
            }
        }
        */

        return legalMoves;
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
