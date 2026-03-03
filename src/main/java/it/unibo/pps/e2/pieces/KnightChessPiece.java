package it.unibo.pps.e2.pieces;

import it.unibo.pps.e2.Pair;

public class KnightChessPiece implements ChessPiece {
    private final ChessPiece baseChessPiece;

    KnightChessPiece(ChessPiece chessPiece) {
        baseChessPiece = chessPiece;
    }

    @Override
    public void move(int row, int column) {
        int deltaRow = this.baseChessPiece.getPosition().getX() - row;
        int deltaCol = this.baseChessPiece.getPosition().getY() - column;
        if (Math.abs(deltaRow) + Math.abs(deltaCol) == 3) {
            baseChessPiece.move(row, column);
        }
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return baseChessPiece.getPosition();
    }
}
