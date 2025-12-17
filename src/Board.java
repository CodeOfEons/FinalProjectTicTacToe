public class Board {

    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = ' ';
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + grid[i][0] + " | " + grid[i][1] + " | " + grid[i][2]);
            if (i < 2) System.out.println("---|---|---");
        }
        System.out.println();
    }

    // Custom exception handling
    public void placeMark(int row, int col, char symbol)
            throws InvalidMoveException {

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new InvalidMoveException("Position must be between 1 and 3.");
        }

        if (grid[row][col] != ' ') {
            throw new InvalidMoveException("This cell is already occupied.");
        }

        grid[row][col] = symbol;
    }

    public boolean checkWin(char symbol) {

        for (int i = 0; i < 3; i++)
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol)
                return true;

        for (int i = 0; i < 3; i++)
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol)
                return true;

        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol)
            return true;

        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)
            return true;

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == ' ')
                    return false;
        return true;
    }
}
