public class QueensTester
{	
	
	//testBoard(int[])
	//returns boolean value indicating whether or not input configuration is a solution
	public static boolean testBoard(int[] board)
	{
		for(int x = 0; x < board.length; x ++)
			for(int y = 0; y < board.length; y ++)
			{
				if(x != y) 
				{
					if(board[x] == board[y])
						return false;
					if(Math.abs(y - x) == Math.abs(board[y] - board[x]))
						return false;
				}
			}
		return true;
	}	
	
	//printTest(int)
	//prints the number of solutions for a nxn board 
	public static void printTest(int n)
	{
		int[] board = new int[n];
		int solutions = 0;
		for(int x = 0; x < Math.pow(n, n); x ++)
		{
			int y = x;
			for(int z = 0; z < n; z ++)
			{
				board[z] = y / (int)Math.pow(n, n - (1 + z));
				y = y % (int)Math.pow(n, n - (1 + z));
			}
			if(testBoard(board))
				solutions += 1;
		}
		System.out.println("For the case " + n + "x" + n + " there are "  + solutions + " solutions.");
	}	
	
	public static void main(String args[])
	{
		for(int x = 2; x < 9; x ++)
			printTest(x);
	}	
	
}