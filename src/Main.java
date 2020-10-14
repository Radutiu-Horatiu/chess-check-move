public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, chess!");

        Board b = new Board();

        System.out.println(b.checkMove(b.getBox(2,2), 1, 2));

    }
}