package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public class PawnChessPiece extends ChessPiece {
    private boolean isFirstMove = true;

    PawnChessPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean isValidMove(int row, int column) {
        int acceptableOffset = 1;
        if (isFirstMove) {
            isFirstMove = false;
            int currentX = this.getPosition().getX();
            int acceptableFirstOffset = 2;
            return (row == currentX + acceptableFirstOffset ||
                row == currentX + acceptableOffset)
                && this.getPosition().getY() == column;
        } else {
            return row == this.getPosition().getX() + acceptableOffset
                && this.getPosition().getY() == column;
        }
    }
}
