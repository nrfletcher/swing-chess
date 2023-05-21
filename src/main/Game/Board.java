package Game;

/*  Main class for defining logic
 *  Interacts with all piece classes, changing board status when necessary
 *  Board should have no interactions or knowledge of anything outside the Game package
 *  Board is our model in the MVC structure
 *  @author nrileyfletcher
 *  @brief  Logic representation of the chess board
 */

import java.util.ArrayList;

public class Board {

    private Piece[][] currentBoardStatus;
    private ArrayList<Move> validMoves;
    private String currentTurn;
    private int currentWhiteScore;
    private int currentBlackScore;
    private boolean blackFirstMoveMade = false;
    private boolean whiteFirstMoveMade = false;
    private int lastX;
    private int lastY;
    private Piece lastPieceType;

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
        this.validMoves = new ArrayList<>();
        this.currentTurn = "White";
        this.currentWhiteScore = 0;
        this.currentBlackScore = 0;
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

    public boolean isValidMove(Move move) {
        for(Move currMove : validMoves) {
            if(currMove.getY() == move.getY() && currMove.getX() == move.getX()) return true;
        }
        return false;
    }

    public Piece[][] getCurrentBoardStatus() {
        return currentBoardStatus;
    }

    public String getCurrentTurn() {
        return this.currentTurn;
    }

    public void setCurrentTurn(String turn) {
        this.currentTurn = turn;
    }

    public void setCurrentBlackScore(int score) {
        this.currentBlackScore = score;
    }

    public void setCurrentWhiteScore(int score) {
        this.currentWhiteScore = score;
    }

    public int getCurrentWhiteScore() {
        return this.currentWhiteScore;
    }

    public int getCurrentBlackScore() {
        return this.currentBlackScore;
    }

    public void addValidMove(Move move) {
        this.validMoves.add(move);
    }

    public ArrayList<Move> getValidMoves() {
        return this.validMoves;
    }

    public void blackHasMoved() {
        this.blackFirstMoveMade = true;
    }

    public void whiteHasMoved() {
        this.whiteFirstMoveMade = true;
    }

    public boolean hasWhiteMoved() {
        return this.whiteFirstMoveMade;
    }

    public boolean hasBlackMoved() {
        return this.blackFirstMoveMade;
    }

    public int getLastX() {
        return this.lastX;
    }

    public int getLastY() {
        return this.lastY;
    }

    public Piece getLastPieceType() {
        return this.lastPieceType;
    }

    public void setLastX(int x) {
        this.lastX = x;
    }

    public void setLastY(int y) {
        this.lastY = y;
    }

    public void setLastPieceType(Piece pieceType) {
        this.lastPieceType = pieceType;
    }
}
