package it.unibo.pps.e2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private static final int SIZE = 5;
    private static final Pair<Integer, Integer> PAWN_POS = new Pair<>(2, 1);
    private static final Pair<Integer, Integer> KNIGHT_START_POS = new Pair<>(0, 0);
    private Logics logics;


    @BeforeEach
    void init() {
        logics = new LogicsImpl(
            SIZE,
            PAWN_POS,
            KNIGHT_START_POS
        );
    }

    @Test
    public void testHasPawnFoundPawn() {
        assertTrue(logics.hasPawn(PAWN_POS.getX(), PAWN_POS.getY()));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "0, 0",
        "3, 3",
        "10, 10"
    })
    public void testHasPawnNoPawn(int x, int y) {
        assertFalse(logics.hasPawn(x, y));
    }

    @Test
    public void testHasKnightFoundKnight() {
        assertTrue(logics.hasKnight(KNIGHT_START_POS.getX(), KNIGHT_START_POS.getY()));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "1, 2",
        "20, 15"
    })
    public void testHasKnightNoKnight (int x, int y) {
        assertFalse(logics.hasKnight(x, y));
    }

    @Test
    public void testOutOfBoundsMove() {
        int x = SIZE;
        int y = SIZE;
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(x, y));
    }

    @Test
    public void testIllegalMove() {
        int x = KNIGHT_START_POS.getX() + SIZE - 1;
        int y = KNIGHT_START_POS.getY() + SIZE - 1;
        logics.hit(x, y);
        assertTrue(logics.hasKnight(KNIGHT_START_POS.getX(), KNIGHT_START_POS.getY()));
    }

    @Test
    public void testHitFoundPawn() {
        int x = PAWN_POS.getX();
        int y = PAWN_POS.getY();
        assertTrue(logics.hit(x, y));
    }

    @Test
    public void testHitNoPawn() {
        int x = KNIGHT_START_POS.getX() + 1;
        int y = KNIGHT_START_POS.getY() + 2;
        assertFalse(logics.hit(x, y));
    }

    @Test
    public void testLegalMove() {
        int x = KNIGHT_START_POS.getX() + 1;
        int y = KNIGHT_START_POS.getY() + 2;
        logics.hit(x, y);
        assertTrue(logics.hasKnight(x, y));
    }
}
