import java.util.Scanner;


public class TicTacToeGame {
	public static void main (String[] args){
		TicTacToeGame game = new TicTacToeGame();
		game.play();
	}	
	
	public void play(){
		Scanner keyboard = new Scanner(System.in);
		//Get players' names
		String[] players = new String[2];
		System.out.println("Please enter player 1's name");
		players[0] = keyboard.next();
		System.out.println("Please enter player 2's name");
		players[1] = keyboard.next();
		TicTacToeBoard board = new TicTacToeBoard();
		//Player 1 goes first
		int player = 0;
		while (!board.isTie() && board.winner() == 0){
			System.out.println(board.toString());	
			System.out.println(players[player] + "'s turn");
			System.out.println("Pick a row between 1 and 3:");
			int row = keyboard.nextInt() - 1;
			System.out.println("Pick a column between 1 and 3:");
			int col = keyboard.nextInt() - 1;
			// Check if the input is valid
			while (!board.validPosition(row, col)) {
				System.out.println("ILLEGAL CHOICE! TRY AGAIN...");
				System.out.println("Pick a row between 1 and 3:");
				row = keyboard.nextInt() - 1;
				System.out.println("Pick a column between 1 and 3:");
				col = keyboard.nextInt() - 1;
			}
			board.setState(row, col, 1);
			//Change to another player (0 or 1)
			player = (player+1)%2;
		}
		keyboard.close();
		//If we have a winner
		if(board.winner() != 0) {
			System.out.print("Game Over - ");
			System.out.println(players[board.winner()] + " WINS!!!");
		}
		//If the game is tied
		if(board.isTie()){
			System.out.println("Game is tied!");
		}
	}
}
