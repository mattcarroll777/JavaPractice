import java.util.Scanner;

public class ticTacToe {

    private final char[][] board;
    private char currentPlayerMark;

    public ticTacToe() {
        this.board = new char[3][3];
        this.currentPlayerMark = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("Current game state:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to play a move
    public boolean playMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayerMark;
            return true;
        }
        return false;
    }

    // Method to switch players
    public void switchPlayer() {
        currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        ticTacToe game = new ticTacToe();
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {
            System.out.println("Current board layout:");
            game.printBoard();
            System.out.println("Player " + game.currentPlayerMark + ", enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1; // Subtracting 1 to match array indexing
            int col = scanner.nextInt() - 1;
            if (game.playMove(row, col)) {
                game.switchPlayer();
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again.");
            }
            // Here you would check for a win or a draw and set play = false accordingly
        }
        scanner.close();
    }
}

