package Game;

import java.util.ArrayList;

/* @author nrileyfletcher
 * @brief Bishop piece implementation
 */
public class Bishop implements Piece {

    private final String color;

    public Bishop(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Move> getLegalMoves(Piece[][] currentBoard, int row, int col) {
        ArrayList<Move> legalMoves = new ArrayList<>();
        String color = currentBoard[row][col].getPieceColor();

        /* Beware hectic code; essentially just traversing each diagonal checking for nulls or pieces */
        if(color.equalsIgnoreCase("black")) {
            boolean seenPiece = false;
            int counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].getPieceColor().equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].getPieceColor().equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].getPieceColor().equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].getPieceColor().equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }
        } else {
            boolean seenPiece = false;
            int counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].getPieceColor().equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].getPieceColor().equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].getPieceColor().equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].getPieceColor().equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].getPieceColor().equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col + counter));
                    }
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
        return "BISHOP";
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
