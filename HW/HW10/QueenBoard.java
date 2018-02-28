//Andrew Shao
//APCS2 pd2
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-28W

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    if(solveH(0))
		return true;
	for(int x = 0; x < Math.pow(_board.length, 2); x ++)//fills board with 0's
		_board[x / _board.length][x % _board.length] = 0;
	return false;
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    if(col == _board.length)
		return true;
	for(int row = 0; row < _board.length; row ++)
	{
		if(addQueen(row, col))
		{
			if(solveH(col + 1))
				return true;
			removeQueen(row,col);
		}
	}
	return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
	System.out.println();
	for( int r = 0; r < _board.length; r++ )
	{
	    for( int c = 0; c < _board[0].length; c++ )
		{
			if(_board[r][c] < 1)
				System.out.print("_");
			else
				System.out.print("Q");
			System.out.print(" ");
	    }
	    System.out.println();
    }
	System.out.println();
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Adds a queen to the board and marks positions where additional queens can't be placed.
   * precondition: Input integers are less than board dimensions.
   * postcondition: If a queen can be put at the inputed position, the position will be marked with a 1
   * and all positions to the right of the inputed position where queens can't be placed
   * will have their values decremented by 1. Returns true.
   * If a queen can't be placed at the inputed position returns false.
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Removes a queen from the board and undoes the marking of positions by placing that queen.
   * precondition: Input integers are less than board dimensions.
   * postcondition: If a queen is at the inputed position, the value at the position will be changed 
   * back to 0 and all positions decremented by the placement of that queen will be incremented by 1.
   * Returns true.
   * If there is no queen at the inputed position returns false.
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: 
   * postcondition: 
   */
  public String  toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    // QueenBoard b = new QueenBoard(5);
    // System.out.println(b);
    // b.addQueen(3,0);
    // b.addQueen(0,1);
    // System.out.println(b);
    // b.removeQueen(3,0);
    // System.out.println(b);
	QueenBoard c;
	for(int x = 2; x < 9; x ++)
	{
		c = new QueenBoard(x);
		c.solve();
		System.out.println("Solution for " + x + "x" + x + ":");
		c.printSolution();
	}
  }
    
}//end class
