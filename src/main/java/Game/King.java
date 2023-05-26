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
        int[][] positions = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}};

        /* Checks each unique (x, y) pair from positions array */
        if(color.equalsIgnoreCase("black")) {
            for(int i = 0; i < positions.length; i++) {
                for(int j = 0; j < 1; j++) {
                    if(moveInBounds(new Move(row + positions[i][j], col + positions[i][j+1])) &&
                            !currentBoard[row + positions[i][j]][col + positions[i][j+1]].
                                    getPieceColor().
                                    equalsIgnoreCase("black")) legalMoves.add(new Move(row + positions[i][j], col + positions[i][j+1]));
                }
            }
        } else {
            for(int i = 0; i < positions.length; i++) {
                for(int j = 0; j < 1; j++) {
                    if(moveInBounds(new Move(row + positions[i][j], col + positions[i][j+1])) &&
                            !currentBoard[row + positions[i][j]][col + positions[i][j+1]].
                                    getPieceColor().
                                    equalsIgnoreCase("white")) legalMoves.add(new Move(row + positions[i][j], col + positions[i][j+1]));
                }
            }
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
        return move.getY() <= 7 && move.getY() >= 0 && move.getX() <= 7 && move.getX() >= 0;
    }
}
