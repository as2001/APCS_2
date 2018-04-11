//	Andrew Shao
//	APCS2 pd2
//	HW31 -- Stack: What Is It Good For?
//	2018-04-11T

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
	Latkes tmp = new Latkes( s.length() );
	while( s.length() > 1 ) {
		tmp.push( s.substring( 0, 1 ) );
		s = s.substring( 1 );
	}
	while( !tmp.isEmpty() )
		s += tmp.pop();
	return s;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
	Latkes tmp = new Latkes( s.length() );
	String holder = "";
	for( int x = 0; x < s.length(); x ++ ) {
		//basically if holder and s.substring( x, x + 1 ) aren't a pair of parens
		if ( !(holder.equals( "{" ) && s.substring( x, x + 1 ).equals( "}" )) )
			if ( !(holder.equals( "[" ) && s.substring( x, x + 1 ).equals( "]" )) )
				if ( !(holder.equals( "(" ) && s.substring( x, x + 1 ).equals( ")" )) ) {
					tmp.push( holder );
					tmp.push( s.substring( x, x + 1 ) );
				}
		holder = tmp.pop();
	}
	return tmp.isEmpty();
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
