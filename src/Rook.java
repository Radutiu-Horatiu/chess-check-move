public class Rook extends Piece {

    public Rook(boolean white)
    {
        super(white);
    }

    @Override
    public boolean canMove(Spot[][] b, Spot start, Spot end) {
        int fromRow = start.getX();
        int toRow = end.getX();
        int fromCol = start.getY();
        int toCol = end.getY();

        int i;

        // Attempt to move to the same cell
        if (fromRow == toRow && fromCol == toCol)
            return false;

        // Collision detection
        if (fromRow == toRow) {
            // Horizontal move
            if (fromCol < toCol) {
                // Move right
                for (i = fromCol + 1; i <= toCol; ++i)
                    if (b[fromRow][i].getPiece() != null)
                        return b[fromRow][i].getPiece().isWhite() != start.getPiece().isWhite();
            } else {
                // Move left
                for (i = fromCol - 1; i >= toCol; --i)
                    if (b[fromRow][i].getPiece() != null)
                        return b[fromRow][i].getPiece().isWhite() != start.getPiece().isWhite();
            }
        } else if (fromCol == toCol) {
            // Vertical move
            if (fromRow < toRow) {
                // Move down
                for (i = fromRow + 1; i <= toRow; ++i)
                    if (b[i][fromCol].getPiece() != null)
                        return b[i][fromCol].getPiece().isWhite() != start.getPiece().isWhite();
            } else {
                // Move up
                for (i = fromRow - 1; i >= toRow; --i)
                    if (b[i][fromCol].getPiece() != null)
                        return b[i][fromCol].getPiece().isWhite() != start.getPiece().isWhite();
            }
        } else {
            // Not a valid rook move (neither horizontal nor vertical)
            return false;
        }

        return true;
    }
}
