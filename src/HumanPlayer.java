import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void makeMove(Board board) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(
                        name + "'s turn (" + symbol + ") - Enter row and column (1-3): "
                );

                int row = sc.nextInt();
                int col = sc.nextInt();

                // Convert to 0-based index
                row--;
                col--;

                board.placeMark(row, col, symbol);
                break;

            } catch (InvalidMoveException e) {
                System.out.println("Invalid move! " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Please enter numeric values only.");
                sc.nextLine(); // clears buffer
            }
        }
    }
}
