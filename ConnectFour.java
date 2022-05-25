/**
 * ConnectFour Class creates and executes ConnectFour board game
 * @author Zeb J-A
 * @version 05/25/22
 */
public class ConnectFour implements BoardGame {
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;
    private int winner;

    public ConnectFour() {
        newGame();
    }

    /**
     * Method newGame creates playing board and initializes each square
     */
    public void newGame() {
        board = new int[6][7];
        winningPositions = new Position[4];
        currentPlayer = 1 + (int)(Math.random()*2);
        winner = -1;
    }

    /**
     * Method getCurrentPlayer returns player whose turn it is
     * @return
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Method gameOver determines whether there are four playing pieces in a row anywhere on the board after each turn
     * @return
     */
    public boolean gameOver() {
        //horizontal
        for(int r = 5; r >= 0; r--) {
            for(int c = 0; c <= 3; c++) {
                if(board[r][c] != 0 && board[r][c] == board[r][c+1] && board[r][c+1] == board[r][c+2] && board[r][c+2] == board[r][c+3] && board[r][c+3] == board[r][c+4]) {
                    for(int i = 0; i < r+4; i++)
                        winningPositions[i] = new Position(r, c+i);
                    winner = board[r][c];
                    return true;
                }

            }
        }
        for(int r = 5; r >= 3; r--) {
            for (int c = 0; c <= 6; c++) {
                if(board[r][c] != 0 && board[r][c] == board[r-1][c] && board[r-1][c] == board[r-2][c] && board[r-2][c] == board[r-3][c] && board[r-3][c] == board[r-4][c]) {
                    for(int i = 0; i < r+4; i++)
                        winningPositions[i] = new Position(r-i, c);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        // diagonal l -> r up
        for(int r = 5; r >= 3; r--) {
            for(int c = 0; c <=3; c++) {
                if(board[r][c] != 0 && board[r][c] == board[r-1][c+1] && board[r-1][c+1] == board[r-2][c+2] && board[r-2][c+2] == board[r-3][c+3] && board[r-3][c+3] == board[r-4][c+4]) {
                    for(int i = 0; i < r+4; i++)
                        winningPositions[i] = new Position(r-i, c+i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        //diagonal r -> l up
        for(int r = 5; r >= 3; r--) {
            for(int c = 3; c <= 6; c++) {
                if(board[r][c] != 0 && board[r][c] == board[r-1][c-1] && board[r-1][c-1] == board[r-2][c-2] && board[r-2][c-2] == board[r-3][c-3] && board[r-3][c-3] == board[r-4][c-4]) {
                    for(int i = 0; i < r+4; i++)
                        winningPositions[i] = new Position(r-i, c-i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        //diagonal r -> l down
        for(int r = 0; r <= 3; r++) {
            for(int c = 6; c >= 3; c--) {
                if(board[r][c] != 0 && board[r][c] == board[r+1][c-1] && board[r+1][c-1] == board[r+2][c-2] && board[r+2][c-2] == board[r+3][c-3] && board[r+3][c-3] == board[r+4][c-4]) {
                    for(int i = 0; i < r+4; i++)
                        winningPositions[i] = new Position(r+i, c-i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        //diagonal l -> r down
        for(int r = 2; r >= 0; r--) {
            for(int c = 3; c >= 0; c--) {
                if(board[r][c] != 0 && board[r][c] == board[r+1][c+1] && board[r+1][c+1] == board[r+2][c+2] && board[r+2][c+2] == board[r+3][c+3] && board[r+3][c+3] == board[r+4][c+4]) {
                    for(int i = 0; i < r+4; i++)
                        winningPositions[i] = new Position(r+i, c+i);
                    winner = board[r][c];
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method get winner returns the player whose 4 pieces are in a row
     * @return
     */
    public int getWinner() {
        return winner;
    }

    /**
     * Method getWinningPositions returns the places where each gamepiece that helped the win is
     * @return
     */
    public Position[] getWinningPositions() {
        return winningPositions;
    }

    /**
     * Method columnFull makes sure pieces do not overflow in any column
     * @param column the column number
     * @return
     */
    public boolean columnFull(int column) {
        for(int r = 0; r < board.length; r++) {
            if(board[r][column] == 0)
                return false;
        }
        return true;
    }

    /**
     * Method play executes the playing of a game piece at a certain position
     * @param column the column number
     */
    public void play(int column) {
        if(!columnFull(column)) {
            for(int r = 5; r >= 0; r--) {
                if(board[r][column] == 0) {
                    board[r][column] = currentPlayer;
                    break;
                }
            }
        }
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    @Override
    /**
     * Method getBoard returns the playing board
     */
    public int[][] getBoard() {
        return board;
    }

}
