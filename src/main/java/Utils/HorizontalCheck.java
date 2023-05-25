package Utils;

import Game.Move;
import Game.Piece;

import java.util.ArrayList;

/*
 * @author nrileyfletcher
 * @brief reusable checking of horizontal lines
 */
public class HorizontalCheck {

    private final Piece[][] currentBoard;
    private final int row;
    private final int col;

    public HorizontalCheck(Piece[][] currentBoard, int row, int col) {
        this.currentBoard = currentBoard;
        this.row = row;
        this.col = col;
    }

    public ArrayList<Move> getLegalHorizontalMoves() {
        ArrayList<Move> legalMoves = new ArrayList<>();
        String color = currentBoard[row][col].getPieceColor();

        /* Beware hectic code; essentially just traversing each horizontal checking for nulls or pieces */
        if(color.equalsIgnoreCase("black")) {
            boolean seenPiece = false;
            int counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col)) && currentBoard[row + counter][col].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col)) &&
                            currentBoard[row + counter][col].
                                    getPieceColor().
                                    equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row, col - counter)) && currentBoard[row][col - counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row, col - counter)) && currentBoard[row][col - counter].
                            getPieceColor().
                            equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row, col - counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row, col + counter)) && currentBoard[row][col + counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row, col + counter)) && currentBoard[row][col + counter].
                            getPieceColor().
                            equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col)) && currentBoard[row - counter][col].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col)) && currentBoard[row - counter][col].
                            getPieceColor().
                            equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row - counter, col));
                    }
                }
            }
        } else {
            boolean seenPiece = false;
            int counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col)) && currentBoard[row + counter][col].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col)) &&
                            currentBoard[row + counter][col].
                                    getPieceColor().
                                    equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row, col - counter)) && currentBoard[row][col - counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row, col - counter)) && currentBoard[row][col - counter].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row, col - counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row, col + counter)) && currentBoard[row][col + counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row, col + counter)) && currentBoard[row][col + counter].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col)) && currentBoard[row - counter][col].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col)) && currentBoard[row - counter][col].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row - counter, col));
                    }
                }
            }
        }

        return legalMoves;
    }

    public boolean moveInBounds(Move move) {
        return move.getY() <= 7 && move.getY() >= 0 && move.getX() <= 7 && move.getX() >= 0;
    }
}
