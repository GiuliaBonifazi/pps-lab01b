package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseChessPieceTest extends ChessPieceTest{

    @BeforeEach
    @Override
    public void init() {
        chessPiece = new BaseChessPiece(INITIAL_POSITION);
    }

    @Test
    @Override
    public void testMove() {
        Pair<Integer, Integer> newPosition = new Pair<>(2, 2);
        chessPiece.move(newPosition.getX(), newPosition.getY());
        assertEquals(newPosition, chessPiece.getPosition());
    }
}
