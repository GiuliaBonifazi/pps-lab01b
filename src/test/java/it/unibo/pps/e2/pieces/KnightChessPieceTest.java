package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightChessPieceTest extends ChessPieceTest {

    @BeforeEach
    @Override
    public void init() {
        ChessPiece baseChessPiece = new BaseChessPiece(INITIAL_POSITION);
        chessPiece = new KnightChessPiece(baseChessPiece);
    }

    private static Stream<Arguments> provideLegalMovesFromInit() {
        int OFFSET1 = 1;
        int OFFSET2 = 2;
        return Stream.of(
            Arguments.of(
              INITIAL_POSITION.getX() + OFFSET1,
              INITIAL_POSITION.getY() + OFFSET2),
            Arguments.of(INITIAL_POSITION.getX() + OFFSET2,
                INITIAL_POSITION.getY() + OFFSET1),
            Arguments.of(
                INITIAL_POSITION.getX() - OFFSET1,
                INITIAL_POSITION.getY() + OFFSET2),
            Arguments.of(
                INITIAL_POSITION.getX() + OFFSET1,
                INITIAL_POSITION.getY() - OFFSET2),
            Arguments.of(INITIAL_POSITION.getX() - OFFSET2,
                INITIAL_POSITION.getY() + OFFSET1),
            Arguments.of(INITIAL_POSITION.getX() + OFFSET2,
                INITIAL_POSITION.getY() - OFFSET1),
            Arguments.of(INITIAL_POSITION.getX() - OFFSET2,
                INITIAL_POSITION.getY() - OFFSET1)
            );
    }

    @ParameterizedTest
    @MethodSource("provideLegalMovesFromInit")
    @Override
    public void testMove(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        chessPiece.move(newPosition.getX(), newPosition.getY());
        assertEquals(newPosition, chessPiece.getPosition());
    }
}
