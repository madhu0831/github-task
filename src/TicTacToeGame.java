
import java.util.Scanner;

import java.util.Scanner;

public class TicTacToeGame {
    private static final char[] PLAYERS = {'X', 'O'};
    private char[][] board;
    private int currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayer = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) ||
                (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = PLAYERS[currentPlayer];
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Tic Tac Toe Game!");
        game.printBoard();
        int row, col;
        
        while (true) {
            System.out.println("Player " + PLAYERS[game.currentPlayer] + ", enter an empty row and column to place your mark!");
            row = scanner.nextInt() - 1; // 1-based to 0-based index
            col = scanner.nextInt() - 1;
            if (game.placeMark(row, col)) {
                game.printBoard();
                if (game.checkForWin()) {
                    System.out.println("Player " + PLAYERS[game.currentPlayer] + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    System.out.println("The game is a draw!");
                    break;
                }
                game.changePlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        scanner.close();
    }
}
