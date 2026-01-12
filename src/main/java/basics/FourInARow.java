package basics;


/**
 * A class that represents a game of Four in a Row.
 * The game is played on a 6x7 board.
 * A player wins when he has 4 pieces in a row, column or diagonal.
 *
 * ForInARow is a two-player connection rack game, in which the players choose a color and
 * then take turns dropping colored tokens into a six-row, seven-column vertically suspended grid.
 * The pieces fall straight down, occupying the lowest available space within the column.
 *
 * The objective of the game is to be the first to form a horizontal,
 * vertical, or diagonal line of four of one's own tokens.
 *
 * Your taks is to model the game and implement the method hasWon(char player) that returns true.
 * if the player has won the game.
 * We advise you to model the state of the game with an internal 2D array of char.
 */
public class FourInARow {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    private static final char EMPTY = '-';
    private static final char[] PLAYERS = {'X', 'O'};

     // add your own instance variables here
    private char[][] board;
    private int[] nbInColumn; // nbInColumn[j] = number of pieces in column j


    public FourInARow() {
         // add your own code here
        board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) for (int j = 0; j < COLUMNS; j++) {
            board[i][j] = EMPTY;
        }
        nbInColumn = new int[COLUMNS];
    }

    /**
     * Play a piece in column j for the given player.
     * @param j the column index
     * @param player the player (X or O)
     * @throws IllegalArgumentException if j is not a valid column index or if the column is full or if the player is not X or O
     */
    public void play(int j, char player) {
         // add your own code here
        if (j < 0 || j >= COLUMNS) throw new IllegalStateException("Invalid column");
        if (nbInColumn[j] == ROWS) throw new IllegalArgumentException("The column " + j + " is full");
        if (player != PLAYERS[0] && player != PLAYERS[1]) throw new IllegalArgumentException("Invalid Token");

        board[nbInColumn[j]][j] = player;
        nbInColumn[j]++;
    }


    /**
     * Returns true if the player has won the game.
     * @param player the player (X or O)
     * @return true if the player has won the game
     * @throws IllegalArgumentException if the player is not X or O
     */
    public boolean hasWon(char player) {
         // add your own code here

        if (player != PLAYERS[0] && player != PLAYERS[1]) throw new IllegalArgumentException("Illegal Token");

        for (int i = 0; i < ROWS; i++) for (int j = 0; j < COLUMNS; j++) {
            if (board[i][j] == player) {
                // check horizontal
                if (j+3 < COLUMNS &&
                        board[i][j+1] == player &&
                        board[i][j+2] == player &&
                        board[i][j+3] == player) {
                    return true;
                }

                // check vertical
                if (i+3 < ROWS &&
                        board[i+1][j] == player &&
                        board[i+2][j] == player &&
                        board[i+3][j] == player) {
                    return true;
                }

                // check first diagonal
                if (j+3 < COLUMNS && i+3 < ROWS &&
                        board[i+1][j+1] == player &&
                        board[i+2][j+2] == player &&
                        board[i+3][j+3] == player) {
                    return true;
                }

                // check second diagonal
                if (j-3 >= 0 && i+3 < ROWS &&
                        board[i+1][j-1] == player &&
                        board[i+2][j-2] == player &&
                        board[i+3][j-3] == player) {
                    return true;
                }
            }

        }
        return false;
    }
}
