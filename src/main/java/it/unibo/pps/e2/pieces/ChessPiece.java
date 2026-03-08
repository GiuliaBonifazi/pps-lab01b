package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public abstract class ChessPiece {
    private Pair<Integer, Integer> position;

    ChessPiece(Pair<Integer, Integer> position) {
        this.position = position;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    private boolean didMove(int row, int column) {
        return row != position.getX() || column != position.getY();
    }

    abstract boolean isValidMove(int row, int column);


    public boolean move(int row, int column) {
        if (didMove(row, column) && isValidMove(row, column)) {
            this.position = new Pair<>(row, column);
            return true;
        }
        return false;
    }
}
