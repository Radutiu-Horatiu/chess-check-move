public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot[][] b, Spot start, Spot end) {
        int fromRow = start.getX();
        int toRow = end.getX();
        int fromCol = start.getY();
        int toCol = end.getY();

        int[] X = new int[]{ 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] Y = new int[]{ 1, 2, 2, 1, -1, -2, -2, -1 };

        // Check if each possible move is valid or not
        for (int i = 0; i < 8; i++) {

            // Position of knight after move
            int x = fromRow + X[i];
            int y = fromCol + Y[i];

            // index isn't out of range and we don't step over teammate or we step on enemy
            if (x >= 0 && y >= 0 && x < 4 && y < 4 &&
                    (x == toRow && y == toCol) &&
                    (b[x][y].getPiece() == null || b[x][y].getPiece().isWhite() != start.getPiece().isWhite()))
                return true;
        }

        return false;
    }
}
