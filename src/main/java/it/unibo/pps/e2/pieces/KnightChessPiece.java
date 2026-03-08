package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public class KnightChessPiece extends ChessPiece {

    KnightChessPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean isValidMove(int row, int column) {
        int deltaRow = this.getPosition().getX() - row;
        int deltaCol = this.getPosition().getY() - column;
        return Math.abs(deltaRow) + Math.abs(deltaCol) == 3;
    }
}
