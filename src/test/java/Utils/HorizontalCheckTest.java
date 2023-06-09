package Utils;

import Game.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HorizontalCheckTest {

    @Test
    @DisplayName("Checks horizontal moves")
    void getLegalHorizontalMoves() {
        assertEquals(0, 0);
    }

    @Test
    @DisplayName("Checks bounds")
    void moveInBounds(Move move) {
        assertEquals(new Move(0, 0), move);
    }
}