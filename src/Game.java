import java.util.Scanner;

public class Game {

    public static void main(String[] args) {


        System.out.println(" _   _      _             _             ");
        System.out.println("| | (_)    | |           | |            ");
        System.out.println("| |_ _  ___| |_ __ _  ___| |_ ___   ___ ");
        System.out.println("| __| |/ __| __/ _` |/ __| __/ _ \\ / _ \\");
        System.out.println("| |_| | (__| || (_| | (__| || (_) |  __/");
        System.out.println(" \\__|_|\\___|\\__\\__,_|\\___|\\__\\___/ \\___|");
        System.out.println();


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Play Game");
            System.out.println("2. View Leaderboard");
            System.out.println("3. Exit\n");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            if (choice == 1) {
                startGame(sc);
            } else if (choice == 2) {
                LeaderboardManager.showLeaderboard();
            } else if (choice == 3) {
                System.out.println("Thank you for playing!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private static void startGame(Scanner sc) {

        System.out.print("Enter Player 1 name: ");
        String p1Name = sc.nextLine();

        System.out.print("Enter Player 2 name: ");
        String p2Name = sc.nextLine();

        Player player1 = new HumanPlayer(p1Name, 'X');
        Player player2 = new HumanPlayer(p2Name, 'O');

        Board board = new Board();
        Player currentPlayer = player1;

        while (true) {
            board.displayBoard();
            currentPlayer.makeMove(board);

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins!");

                // Save winner to file
                LeaderboardManager.saveWinner(currentPlayer.getName());
                break;
            }

            if (board.isFull()) {
                board.displayBoard();
                System.out.println("Game Draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
