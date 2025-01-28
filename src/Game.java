import java.util.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);
        board.printBoard();

        String PlayerName;

        System.out.println("P1--Enter your name: ");
        PlayerName = scanner.nextLine();
        Player P1 = new Player(PlayerName, "x");
        System.out.println("P2--Enter your name: ");
        PlayerName = scanner.nextLine();
        Player P2 = new Player(PlayerName, "o");

        Boolean winner = false;

        while (winner==false) {
            System.out.println(P1.name + " enter a row number: ");
            int row = scanner.nextInt();
            System.out.println(P1.name + " enter a column number: ");
            int column = scanner.nextInt();

            String answ = scanner.nextLine();
            System.out.println("Would you like to undo? If yes press u");
            answ = scanner.nextLine();

            if  (answ.equals("u")) {
                System.out.println(board.undo());
            }
            else if (board.makeMove(row, column, P1.symbol)) {    // dion updated by calling method
                board.printBoard();
            }


            System.out.println(P2.name + " enter a row number: ");
            row = scanner.nextInt();
            System.out.println(P2.name + " enter a column number: ");
            column = scanner.nextInt();

            String anser = scanner.nextLine();
            System.out.println("Would you like to undo? If yes press u");
            anser = scanner.nextLine();

            if  (anser.equals("u")) {
                System.out.println(board.undo());

            }
            else if (board.makeMove(row, column, P2.symbol)) {    // dion updated by calling method
                board.printBoard();
            }
        }
    }
}