package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public abstract void testMove();
}
