public class Piece {
    
    static String[] types = {
            "ROOK", "KNIGHT", "PAWN", "KING", "QUEEN"
    };

    String color;
    String type;

    private Piece(String color, String type) {
        this.color = color;
        this.type = type;
    }
}
