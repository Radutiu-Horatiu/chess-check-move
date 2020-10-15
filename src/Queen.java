public class Queen extends Piece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot[][] b, Spot start, Spot end) {

        b[start.getX()][start.getY()] = new Spot(start.getX(), start.getY(), new Bishop(start.getPiece().isWhite()));
        boolean bishopOk = b[start.getX()][start.getY()].getPiece().canMove(b, start, end);

        b[start.getX()][start.getY()] = new Spot(start.getX(), start.getY(), new Rook(start.getPiece().isWhite()));
        boolean rookOk = b[start.getX()][start.getY()].getPiece().canMove(b, start, end);

        return bishopOk || rookOk;
    }
}