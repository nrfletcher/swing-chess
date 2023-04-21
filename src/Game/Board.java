package Game;

/*  Main class for defining logic
 *  Interacts with all piece classes, changing board status when necessary
 *  Board should have no interactions or knowledge of anything outside the Game package
 *  Board is our model in the MVC structure
 */

public class Board {

    public int[][] boardPositions;
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
        this.boardPositions = new int[8][8];
    }

    public void newGamePiecePositions() {
        this.boardPositions = new int[][]{
                {BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_KING, BLACK_QUEEN, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK},
                {BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN},
                {NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE},
                {NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE},
                {NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE},
                {NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE, NO_PIECE},
                {WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN},
                {WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_KING, WHITE_QUEEN, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK},
        };
    }

    public void getCurrentPiecePositionsNumerically() {
        for(int i = 0; i < 8; i++) {
            System.out.println();
            for(int j = 0; j < 8; j++) {
                System.out.print(boardPositions[i][j]);
            }
        }
    }

    private final String[] pieceValuesAsNames = {"W_PAWN", "W_ROOK", "W_BISHOP", "W_KNIGHT", "W_QUEEN", "W_KING",
        "B_PAWN", "B_ROOK", "B_BISHOP", "B_KNIGHT", "B_QUEEN", "B_KING", "NONE"};

    public void getCurrentPiecePositionNames() {
        for(int i = 0; i < 8; i++) {
            System.out.println();
            for(int j = 0; j < 8; j++) {
                System.out.print(pieceValuesAsNames[boardPositions[i][j]] + " ");
            }
        }
    }
}
