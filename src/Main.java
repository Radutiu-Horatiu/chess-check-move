public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, chess!");

        // pieces on the board are initialized in Board constructor
        Board b = new Board();

        // check rook moves across the table
        b.checkMove(b.getBox(0,0),0,7);

        // check knight attacks bishop
        b.checkMove(b.getBox(1,2),3,3);

        // check bishop attacks knight but are same color
        b.checkMove(b.getBox(4,5),1,2);

        // check queen attacks enemy pawn
        b.checkMove(b.getBox(2,2),1,3);

        // check pawn attacks enemy queen
        b.checkMove(b.getBox(1,3),2,2);

        // check empty spot moves somewhere
        b.checkMove(b.getBox(7,0), 5, 5);
    }
}