public class Pawn extends Piece {

    public Pawn(boolean white)
    {
        super(white);
    }

    @Override
    public boolean canMove(Spot[][] b, Spot start, Spot end) {
        int fromRow = start.getX();
        int toRow = end.getX();
        int fromCol = start.getY();
        int toCol = end.getY();

        if (toRow > 0 && toRow < 6 && toCol > 0 && toCol < 8)
            return false;
        // white pieces are one rows 6, 7
        else if (start.getPiece().isWhite()) {
            // simple one step move
            if (fromRow == toRow - 1 && toCol == fromCol)
                return true;
            // from start 2 steps move
            else if (fromRow == toRow - 2 && toCol == fromCol && fromRow == 6)
                return true;
            // pawn attacking on diagonal
            else return fromRow == toRow - 1 && (fromCol == toCol - 1 || fromCol == toCol + 1) && end.getPiece() != null;
        }
        // black pieces are on rows 1, 2
        else {
            // simple one step move
            if (fromRow == toRow + 1 && toCol == fromCol)
                return true;
                // from start 2 steps move
            else if (fromRow == toRow + 2 && toCol == fromCol && fromRow == 1)
                return true;
                // pawn attacking on diagonal
            else return fromRow == toRow + 1 && (fromCol == toCol - 1 || fromCol == toCol + 1) && end.getPiece() != null;
        }
    }
}