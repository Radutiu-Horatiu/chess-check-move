public class Bishop extends Piece {

    public Bishop(boolean white)
    {
        super(white);
    }

    @Override
    public boolean canMove(Spot[][] b, Spot start, Spot end) {
        int fromRow = start.getX();
        int toRow = end.getX();
        int fromCol = start.getY();
        int toCol = end.getY();

        //all possible moves in the down positive diagonal
        for (int j = fromCol + 1, i = fromRow + 1; j < 8 && i < 8; j++, i++) {
            if (i == toRow && j == toCol &&
                    (b[i][j].getPiece() == null || start.getPiece().isEnemy(b[i][j].getPiece()))) {
                return true;
            }
        }

        //all possible moves in the up positive diagonal
        for (int j = fromCol - 1, i = fromRow + 1; j > -1 && i < 8; j--, i++) {
            if (i == toRow && j == toCol &&
                    (b[i][j].getPiece() == null || start.getPiece().isEnemy(b[i][j].getPiece()))) {
                return true;
            }
        }

        //all possible moves in the up negative diagonal
        for (int j = fromCol - 1, i = fromRow - 1; j > -1 && i > -1; j--, i--) {
            if (i == toRow && j == toCol &&
                    (b[i][j].getPiece() == null || start.getPiece().isEnemy(b[i][j].getPiece()))) {
                return true;
            }
        }

        //all possible moves in the down negative diagonal
        for (int j = fromCol + 1, i = fromRow - 1; j < 8 && i > -1; j++, i--) {
            if (i == toRow && j == toCol &&
                    (b[i][j].getPiece() == null || start.getPiece().isEnemy(b[i][j].getPiece()))) {
                return true;
            }
        }

        return false;
    }
}
