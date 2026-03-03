package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseChessPieceTest extends ChessPieceTest {

    @BeforeEach
    @Override
    public void init() {
        chessPiece = new BaseChessPiece(INITIAL_POSITION);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "3, 3",
        "4, 5"
    })
    @Override
    public void testMove(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        chessPiece.move(newPosition.getX(), newPosition.getY());
        assertEquals(newPosition, chessPiece.getPosition());
    }
}
