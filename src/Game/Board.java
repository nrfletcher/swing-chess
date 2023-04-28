package Game;

/*  Main class for defining logic
 *  Interacts with all piece classes, changing board status when necessary
 *  Board should have no interactions or knowledge of anything outside the Game package
 *  Board is our model in the MVC structure
 */

public class Board {

    private Piece[][] currentBoardStatus;

    private final int NO_PIECE = 12;

    private final int WHITE_PAWN = 0;
    private final int WHITE_ROOK = 1;
    private final int WHITE_BISHOP = 2;
    private final int WHITE_KNIGHT = 3;
    private final int WHITE_QUEEN = 4;
    private final int WHITE_KING = 5;

    private final int BLACK_PAWN = 6;
    private final int BLACK_ROOK = 7;
    private final int BLACK_BISHOP = 8;
    private final int BLACK_KNIGHT = 9;
    private final int BLACK_QUEEN = 10;
    private final int BLACK_KING = 11;

    public Board() {
        this.currentBoardStatus = new Piece[8][8];
        newGamePiecePositions();
    }

    public void newGamePiecePositions() {
        // Initialize board with starting positions
        this.currentBoardStatus = new Piece[][]{
                {new Rook("Black"), new Knight("Black"), new Bishop("Black"), new Queen("Black"),
                        new King("Black"), new Bishop("Black"), new Knight("Black"), new Rook("Black")},
                {new Pawn("Black"), new Pawn("Black"), new Pawn("Black"), new Pawn("Black"),
                        new Pawn("Black"), new Pawn("Black"), new Pawn("Black"), new Pawn("Black")},
                {new Empty(), new Empty(), new Empty(), new Empty(),
                        new Empty(), new Empty(), new Empty(), new Empty()},
                {new Empty(), new Empty(), new Empty(), new Empty(),
                        new Empty(), new Empty(), new Empty(), new Empty()},
                {new Empty(), new Empty(), new Empty(), new Empty(),
                        new Empty(), new Empty(), new Empty(), new Empty()},
                {new Empty(), new Empty(), new Empty(), new Empty(),
                        new Empty(), new Empty(), new Empty(), new Empty()},
                {new Pawn("White"), new Pawn("White"), new Pawn("White"), new Pawn("White"),
                        new Pawn("White"), new Pawn("White"), new Pawn("White"), new Pawn("White")},
                {new Rook("White"), new Knight("White"), new Bishop("White"), new Queen("White"),
                        new King("White"), new Bishop("White"), new Knight("White"), new Rook("White")},
        };
    }

    public Piece[][] getCurrentBoardStatus() {
        return currentBoardStatus;
    }
}
