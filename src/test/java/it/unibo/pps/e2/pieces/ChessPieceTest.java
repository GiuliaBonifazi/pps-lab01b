package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public abstract class ChessPieceTest {
    protected static final Pair<Integer, Integer> INITIAL_POSITION = new Pair<>(0,0);
    protected ChessPiece chessPiece;

    @BeforeEach
    public abstract void init();

    @Test
    public void testGetPos(){
        assertEquals(INITIAL_POSITION, chessPiece.getPosition());
    }

    @Test
    public void testMoveNoMovement() {
        assertFalse(chessPiece.move(INITIAL_POSITION.getX(), INITIAL_POSITION.getY()));
    }

    @ParameterizedTest
    @CsvSource({
    })
    public abstract void testMove(int row, int col);
}
