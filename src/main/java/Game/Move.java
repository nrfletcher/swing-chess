package Game;

/* @author nrileyfletcher
 * @brief A move is a xy coordinate pair on the chess board
 */
public class Move {

    private final int x;
    private final int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
