package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnChessPieceTest extends ChessPieceTest {

    @BeforeEach
    @Override
    public void init() {
        ChessPiece baseChessPiece = new BaseChessPiece(INITIAL_POSITION);
        chessPiece = new PawnChessPiece(baseChessPiece);
    }

    private static Stream<Arguments> provideLegalMovesFromInit() {
        int acceptableOffset = 1;
        int firstMoveAcceptableOffset = 2;
        return Stream.of(
            Arguments.of(
                INITIAL_POSITION.getX() + firstMoveAcceptableOffset,
                INITIAL_POSITION.getY()),
            Arguments.of(
                INITIAL_POSITION.getX() + acceptableOffset,
                INITIAL_POSITION.getY())
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
