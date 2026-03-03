package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public class BaseChessPiece implements ChessPiece {
    private Pair<Integer, Integer> position;

    BaseChessPiece(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public void move(int row, int column) {
        if (row != position.getX() || column != position.getY()) {
            position = new Pair<>(row, column);
        }
    }
}
