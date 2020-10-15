public class Board {
    Spot[][] boxes = new Spot[8][8];

    public Board() {
        // initialize without any pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }

        // initialize pieces
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[0][7] = new Spot(0, 7, new Rook(true));
        boxes[1][2] = new Spot(1, 2, new Knight(true));
        boxes[5][4] = new Spot(5, 4, new Knight(false));
        boxes[5][5] = new Spot(5, 5, new Knight(false));
        boxes[3][3] = new Spot(3, 3, new Bishop(false));
        boxes[4][5] = new Spot(3, 3, new Bishop(true));
        boxes[2][2] = new Spot(2, 2, new Queen(false));
        boxes[6][1] = new Spot(6, 1, new Pawn(true));
        boxes[1][3] = new Spot(1, 3, new Pawn(true));
        boxes[6][6] = new Spot(6, 6, new Pawn(true));

        printBoard();
    }

    public Spot getBox(int x, int y) {
        return boxes[x][y];
    }

    public void checkMove(Spot start, int x, int y) {
        Piece piece = start.getPiece();
        if (piece != null) {
            System.out.print("\nMove of: ");
            switch (piece.getClass().toString()) {
                case "class Pawn":
                    System.out.print("Pawn ");
                    break;
                case "class Rook":
                    System.out.print("Rook ");
                    break;
                case "class Queen":
                    System.out.print("Queen ");
                    break;
                case "class Knight":
                    System.out.print("Knight ");
                    break;
                case "class Bishop":
                    System.out.print("Bishop ");
                    break;
            }
            System.out.println("\nFrom x = " + start.getX() + " to x = " + x);
            System.out.println("From y = " + start.getY() + " to y = " + y);

            boolean ok = start.getPiece().canMove(this.boxes, start, getBox(x, y));
            if (ok)
                System.out.println("Valid.\n");
            else
                System.out.println("Not valid.\n");
        }
        else
            System.out.println("Spot is empty.");
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = getBox(i, j).getPiece();
                if (piece != null)
                    if (piece.getClass().toString().equals("class Pawn"))
                        System.out.print("P ");
                    else if (piece.getClass().toString().equals("class Rook"))
                        System.out.print("R ");
                    else if (piece.getClass().toString().equals("class Queen"))
                        System.out.print("Q ");
                    else if (piece.getClass().toString().equals("class Knight"))
                        System.out.print("K ");
                    else if (piece.getClass().toString().equals("class Bishop"))
                        System.out.print("B ");
                    else
                        System.out.print("0 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
}