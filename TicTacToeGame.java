import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
			int ans = 0;
			System.out.println("How many players?(1 for one player and 2 for two player)");
			ans = scan.nextInt();
			if(ans == 1)
			withComp();
			else 
			withPlayer();
			
	}

	//if player prompts two players
	public static void withPlayer()
	{
		TicTacToe tr = new TicTacToe();
		
		

		int col = 0;

		int row = 0;

		final String P1 = "O";
		final String P2 = "X";
		boolean p1Turn = true;
		boolean done = false;
		
		while (!done) {

			if (p1Turn) {
				System.out.println("Player 1's Turn: ");
				System.out.println(tr);
				System.out.println("Pick a row and column.\nRow: ");
				row = scan.nextInt() - 1;
				System.out.println("Column: ");
				col = scan.nextInt() - 1;

				tr.set(row, col, P1);
				
				
				if(tr.gameOver())
				{
					done = true;
					System.out.println("Player 1 Wins!\n" + tr);
				}
				else if(tr.catsGame())
				{
					done = true;
					System.out.println("Draw!\n" + tr);
				}
				else
					p1Turn = false;
			} else {
				System.out.println("Player 2's Turn: ");
				System.out.println(tr);
				System.out.println("Pick a row and column.\nRow: ");
				row = scan.nextInt() - 1;
				System.out.println("Column: ");
				col = scan.nextInt() - 1;

				tr.set(row, col, P2);
				
				
				if(tr.gameOver())
				{
					done = true;
					System.out.println("Player 2 Wins!\n" + tr);
				}
				else if(tr.catsGame())
				{
					done = true;
					System.out.println("Draw!\n" + tr);
				}
				else
					p1Turn = true;
			}

		}

		
	}
	
	//if player prompts to play with computer
	public static void withComp()

	{
		TicTacToe tr = new TicTacToe();
		
		

		int col = 0;

		int row = 0;

		final String P1 = "O";
		final String CP = "X";
		CompPlayer cp = new CompPlayer(tr, CP);
		
		boolean p1Turn = true;

		while (!tr.gameOver()) {

			if (p1Turn) {
				System.out.println("Player 1's Turn: ");
				System.out.println(tr);
				System.out.println("Pick a row and column.\nRow: ");
				row = scan.nextInt() - 1;
				System.out.println("Column: ");
				col = scan.nextInt() - 1;

				if(tr.getBoard()[row][col].equals(" "))
				{
				tr.set(row, col, P1);
				p1Turn = false;
				}
				else
					p1Turn = true;
				;
			} else {
				System.out.println("Computer's Turn: ");
				System.out.println(tr);
				cp.makeMove();
				
				
				p1Turn = true;
			}

		}

		if (tr.catsGame())
			System.out.println("Draw!\n" + tr);
		else if (p1Turn)
			System.out.println("Computer Wins!\n" + tr);
		else
			System.out.println("Player 1 Wins!\n" + tr);
	}

	
}
