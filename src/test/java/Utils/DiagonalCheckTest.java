package Utils;

import Game.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiagonalCheckTest {

    @Test
    @DisplayName("Checks diagonal moves")
    void getLegalDiagonalMoves() {
        assertEquals(new ArrayList<Move>(), getLegalDiagonalMoves());
    }
}