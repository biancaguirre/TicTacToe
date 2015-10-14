//package ticTacToeGame;
import java.util.*;

public class PlayTicTacToe
{

	public static void main(String[] args)
	{
		String nameX;
		String nameO;
		char player = TicTacToe.PLAYER_O;
      Scanner kb = new Scanner(System.in); 
		System.out.print("What is the Name of the player who will play X's? ");
		nameX = kb.nextLine();
		System.out.print("What is the Name of the player who will play O's? ");
		nameO = kb.nextLine();
		
		TicTacToe game = new TicTacToe(nameX, nameO);
		String response ="";
		int moves =0;
		do
		{
		   //call the method initializtBoard
			game.initializeBoard();
         game.displayBoard(); 
			for(moves = 1; moves <= 5; moves++)
			{
				if(player == TicTacToe.PLAYER_X){
					player = TicTacToe.PLAYER_O;
            }
				else{
					player = TicTacToe.PLAYER_X;
            }
            game.takeATurn(kb,player);
            System.out.println();
            game.displayBoard();
            System.out.println();
			}
			
			while(!game.isWinner(player) && moves <= 9)
			{
			   if(player == TicTacToe.PLAYER_X){
					player = TicTacToe.PLAYER_O;
            }
				else{
					player = TicTacToe.PLAYER_X;
            }
				game.takeATurn(kb, player);
            System.out.println();
            game.displayBoard();
            System.out.println();
            moves = moves+1;

			}
			
			//call the method display board
			System.out.println();
         game.displayBoard(); 
			
         System.out.println();
			
			//call the method displayResult
			game.displayResults(player, game.isWinner(player), nameX, nameO);
			//ask the user if he/she wants to play again 
			System.out.println("\nWould you like to play again? y or n");
         //set the variable reponse to the user's answer
		
         response = kb.next(); 
			 while(!response.contains("y") && !response.contains("n")){
            System.out.println("I'm sorry, that was not a valid response. Would you like to play again? y or n");
            response = kb.next();
          }
		}while(response.contains("y"));
		//output a good bye messsage
      game.goodBye();
		        
		
	}

}