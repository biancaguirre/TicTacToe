/**
 * Created by biancaaanoel on 5/12/15.
 */

// Bianca Aguirre
// HW #4
// May, 15, 2015
// Tic Tac Toe Class

import java.util.*;

public class TicTacToe {
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    char [][] board = new char[5][5];

    //declare instance variables
    private String xName;
    private String oName;
    private int moveCount;
    private int winX;
    private int winO;

    public TicTacToe(String playerX, String playerO) {
        //initialize the instance variables
        xName = playerX;
        oName = playerO;
        moveCount = 0;
        winX = 0;
        winO = 0;

        //initializing the board
        initializeBoard();
    }
    /*initialize the array representing the board with
    characters '1', '2', ..., '9'  */
    public void initializeBoard() {

        board[0][0] = '1';
        board[0][1] = '|';
        board[0][2] = '2';
        board[0][3] = '|';
        board[0][4] = '3';
        board[1][0] = '-';
        board[1][1] = '-';
        board[1][2] = '-';
        board[1][3] = '-';
        board[1][4] = '-';
        board[2][0] = '4';
        board[2][1] = '|';
        board[2][2] = '5';
        board[2][3] = '|';
        board[2][4] = '6';
        board[3][0] = '-';
        board[3][1] = '-';
        board[3][2] = '-';
        board[3][3] = '-';
        board[3][4] = '-';
        board[4][0] = '7';
        board[4][1] = '|';
        board[4][2] = '8';
        board[4][3] = '|';
        board[4][4] = '9';

    }


    public void takeATurn(Scanner keyboard, char player) {
        //ask each player where they would like to move
        if(player == 'X') {
            System.out.print(xName + ": Where would you like to play?");
        }
        if(player == 'O') {
            System.out.print(oName + ": Where would you like to play?");
        }

        //Enter the an invalid move
        int place = keyboard.nextInt();
        while(!validMove(place, player)) {
            System.out.println(place + " is not a valid move. \nWhere would you like to play?");
            place = keyboard.nextInt();
        }

    }


	/* check the board to see if there is any winner
	by checking the rows and columns*/

    public boolean isWinner(char player) {

        boolean winner = false;

        //check diagonal
        if (board[0][0] == player && board[2][2] == player && board[4][4] == player) {
            winner = true;
        } if (board[0][4] == player && board[2][2] == player && board[4][0] == player) {
            winner = true;
        }
        //check horizontal
        if (board[0][0] == player && board[0][2] == player && board[0][4] == player) {
            winner = true;
        } if (board[2][0] == player && board[2][2] == player && board[2][4] == player) {
            winner = true;
        } if (board[4][0] == player && board[4][2] == player && board[4][4] == player) {
            winner = true;
        }
        //check vertical
        if (board[0][0] == player && board[2][0] == player && board[4][0] == player) {
            winner = true;
        } if (board[0][2] == player && board[2][2] == player && board[4][2] == player) {
            winner = true;
        } if (board[0][4] == player && board[2][4] == player && board[4][4] == player) {
            winner = true;
        }

        return winner;

    }


    /* check to see if the player x is the winner or
       the player y is the winner or the cat is the winner
        or the game is not over yet  and then display the result
         you need to write conditional statements*/
    public void displayResults(char player, boolean win, String xName, String oName) {
        //if xName wins
        if (player == 'X' && win) {
            System.out.print(xName + " is the winner of this game.");
            this.winX = winX + 1;
        }
        //if oName wins
        if (player == 'O' && win) {
            System.out.print(oName + " is the winner of this game.");
            this.winO = winO + 1;
        }
        //if tie
        else if (!win) {
            System.out.println("The game is a tie!");
            this.moveCount = moveCount + 1;
        }

    }


    /* this method checks to see if the position that the player
       wants to play is valid or not. if the given position in the
        array has 'x' or 'o' then it is invalid and also if the
        position is not between 1-9 then is is invalid.
        otherwise it is valid*/
    private boolean validMove(int spot, char player) {
        boolean valid = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //convert char to int
                if (Character.getNumericValue(board[i][j]) == spot) {
                    valid = true;
                    board[i][j] = player;
                    return valid;
                }
            }
        }
        return valid;
    }


    /* display the board showing all the taken spots
       and variable spots. refer to the provided output*/
    public void displayBoard () {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
    }


}