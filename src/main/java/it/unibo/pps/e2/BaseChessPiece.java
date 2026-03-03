package it.unibo.pps.e2;

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
        position = new Pair<>(row, column);
    }
}
