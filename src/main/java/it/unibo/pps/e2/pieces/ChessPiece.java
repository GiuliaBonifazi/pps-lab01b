package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public interface ChessPiece {

    /**
     * Move the piece in the required position.
     *
     * @param row The position x
     * @param column The position y
     */
    void move(int row, int column);

    /**
     * Get the piece's current position.
     *
     * @return The piece's current position.
     */
    Pair<Integer, Integer> getPosition();
}
