public class Board {
    Spot[][] boxes = new Spot[8][8];

    public Board() {
        this.resetBoard();
    }

    public Spot getBox(int x, int y) {
        return boxes[x][y];
    }

    public void resetBoard() {
        // initialize without any pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }

        // initialize pieces
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[1][2] = new Spot(1, 2, new Knight(true));
        boxes[3][3] = new Spot(3, 3, new Bishop(true));
        boxes[2][2] = new Spot(2, 2, new Queen(true));
    }

    public boolean checkMove(Spot start, int x, int y) {
        return start.getPiece().canMove(this.boxes, start, getBox(x, y));
    }
}