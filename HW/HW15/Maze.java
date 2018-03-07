//	Andrew Shao
//	APCS2 pd2
//	HW15 -- Thinkers of the Corn
//	2018-03-07W

/***
 * SKEELTON for class 
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 * 
 * ALGORITHM for finding exit from starting position:
 *  <INSERT YOUR SUMMARY OF ALGO HERE>
 *   What we do is recursively look for the solution by first making sure the maze isn't solved
 *   then, we check if the coordinates entered are valid "moves" by...
 *   1) making sure its within the boundaries of the maze 2d array
 *   2) making sure its not on a wall or on an already existing placement of the "hero" char
 *   then we check if it just landed on the '$', meaning it's been solved
 *   if none of these return true, then we can advance to the next step, which involves moving the char in all four 
 *   cardinal directions, and running the method again with the same coordinates except each one is either incremented by one
 *   or decremented by one, but not both at the same time. This prevents diagonal movement, which Mr. Brown stated was NOT
 *   allowed. 
 *   This allows backtracking as if one certain combination of paths don't work, it uses another one, and another one, until no solution is found.
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver 
{
  private char[][] maze;
  private int h, w; //height, width of maze
  private boolean solved;

  //initialize constants for map component symbols
  final private char HERO =         '@';
  final private char PATH =         '#';
  final private char WALL =         ' ';
  final private char EXIT =         '$';
  final private char VISITED_PATH = '.';


  public MazeSolver( String inputFile ) 
  {
    // init 2D array to represent maze 
    // (80x25 is default terminal window size)
    maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() ) 
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          maze[i][row] = line.charAt( i );

        h++;
        row++;
	    } 

	    for( int i=0; i<w; i++ )
        maze[i][row] = WALL;
	    h++;
	    row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    solved = false;
  }//end constructor


  public String toString() 
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";  
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
        retStr = retStr + maze[j][i];
	    retStr = retStr + "\n";
    }
    return retStr;
  }


  //helper method to keep try/catch clutter out of main flow
  private void delay( int n ) 
  {
    try {
	    Thread.sleep(n);
    } catch( InterruptedException e ) {
	    System.exit(0);
    }
  }


  /*********************************************
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   *********************************************/
  public void solve( int x, int y ) {

    delay(50); //slow it down enough to be followable

    //primary base case
    if ( solved ) {
	    /* YOUR AMAZEING CODE HERE */
		System.out.println(this);
		System.exit(0);
		return;
    }
    //other base case(s)...
    else if ( x > w || x < 0 || y > w || y < 0 ) {
	    /* YOUR AMAZEING CODE HERE */
		return;
    }
    else if ( maze[x][y] == EXIT ) {
	    /* YOUR AMAZEING CODE HERE */
		solved = true;
		return;		
    }
    else if ( ! onPath(x, y) ) {
	    /* YOUR AMAZEING CODE HERE */
		return;
    }
    //recursive reduction
    else {
	    /* YOUR AMAZEING CODE HERE */
		maze[x][y] = HERO;
		System.out.println(this);
		
		maze[x][y] = VISITED_PATH;
		solve(x + 1, y);
		solve(x - 1, y);
		solve(x, y + 1);
		solve(x, y - 1);
		
		if(! solved) {
			maze[x][y] = PATH;
			System.out.println(this);
		}
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

}//end class MazeSolver


public class Maze 
{
  public static void main( String[] args ) 
  {
    try {
	    String mazeInputFile = args[0];

	    MazeSolver ms = new MazeSolver( mazeInputFile );
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 
	    System.out.println( ms );

	    //drop hero into the maze (coords must be on path)
	    //comment next line out when ready to randomize startpos
	    // ms.solve( 0, 0 ); 

	    //drop our hero into maze at random location on path
	    //the Tim Diep way:
	    Random r = new Random();
	    int startX = r.nextInt( 80 );
	    int startY = r.nextInt( 25 );
	    while ( !ms.onPath(startX,startY) ) {
      startX = r.nextInt( 80 );
      startY = r.nextInt( 25 );
	    }

	    ms.solve( startX, startY );
	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    } catch( Exception e ) { 
	    System.out.println( "Error reading input file." );
	    System.out.println( "Usage: java Maze <filename>" ); 
    }
  }

}//end class Maze
