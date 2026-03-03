package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public class PawnChessPiece implements ChessPiece {
    private final ChessPiece baseChessPiece;
    private final int ACCEPTABLE_FIRST_OFFSET = 2;
    private final int ACCEPTABLE_OFFSET = 1;
    private boolean isFirstMove = true;

    PawnChessPiece(ChessPiece baseChessPiece) {
        this.baseChessPiece = baseChessPiece;
    }

    @Override
    public void move(int row, int column) {
        if (isFirstMove) {
            isFirstMove = false;
            int currentX = baseChessPiece.getPosition().getX();
            if ((row == currentX + ACCEPTABLE_FIRST_OFFSET ||
                row == currentX + ACCEPTABLE_OFFSET)
                && baseChessPiece.getPosition().getY() == column) {
                baseChessPiece.move(row, column);
            }
        } else {
            if (row == baseChessPiece.getPosition().getX() + ACCEPTABLE_OFFSET
                && baseChessPiece.getPosition().getY() == column) {
                baseChessPiece.move(row, column);
            }
        }
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return baseChessPiece.getPosition();
    }
}
