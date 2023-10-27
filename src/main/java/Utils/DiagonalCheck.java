package Utils;

import Game.Move;
import Game.Piece;

import java.util.ArrayList;

/*
 * @author nrileyfletcher
 * @brief reusable checking of diagonal lines
 */
public class DiagonalCheck {

    private final Piece[][] currentBoard;
    private final int row;
    private final int col;

    public DiagonalCheck(Piece[][] currentBoard, int row, int col) {
        this.currentBoard = currentBoard;
        this.row = row;
        this.col = col;
    }

    public ArrayList<Move> getLegalDiagonalMoves() {
        ArrayList<Move> legalMoves = new ArrayList<>();
        String color = currentBoard[row][col].getPieceColor();

        /* Diagonal checking (YES IM AWARE THIS IS AWFUL CODE BARE WITH ME) */
        if(color.equalsIgnoreCase("black")) {
            boolean seenPiece = false;
            int counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col + counter)) &&
                            currentBoard[row + counter][col + counter].
                                    getPieceColor().
                                    equalsIgnoreCase("black")) {
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
                if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].
                            getPieceColor().
                            equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col - counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].
                            getPieceColor().
                            equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row - counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].
                            getPieceColor().
                            equalsIgnoreCase("black")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row - counter, col - counter));
                    }
                }
            }
        } else {
            boolean seenPiece = false;
            int counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col + counter)) && currentBoard[row + counter][col + counter].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
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
                if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row + counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row + counter, col - counter)) && currentBoard[row + counter][col - counter].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row + counter, col - counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col + counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col + counter)) && currentBoard[row - counter][col + counter].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row - counter, col + counter));
                    }
                }
            }

            seenPiece = false;
            counter = 1;

            while(!seenPiece) {
                if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].
                        getPieceColor().
                        equalsIgnoreCase("null")) {
                    legalMoves.add(new Move(row - counter, col - counter));
                    counter++;
                } else {
                    if(moveInBounds(new Move(row - counter, col - counter)) && currentBoard[row - counter][col - counter].
                            getPieceColor().
                            equalsIgnoreCase("white")) {
                        seenPiece = true;
                    } else {
                        seenPiece = true;
                        legalMoves.add(new Move(row - counter, col - counter));
                    }
                }
            }
        }

        return legalMoves;
    }

    private boolean moveInBounds(Move move) {
        return move.getY() <= 7 && move.getY() >= 0 && move.getX() <= 7 && move.getX() >= 0;
    }
}
