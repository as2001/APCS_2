//	Andrew Shao
//	APCS2 pd2
//	HW33 -- What a Racket
//	2018-04-13F

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split up the expression into an ordered collection of only operators, parens, and operands
 *   2. Start with the first character in the collection
 *   3.	If the character is not a closing paren, 
 *		push the character to the first stack and go to step 9
 *		Else go to step 4
 *	 4.	Clear the second stack and push the character to that stack
 *	 5.	While the top value of the first stack is not an opening paren, 
 *		push the value returned by popping the first stack into the second stack 
 *	 6. Pop the value on top of the second stack, determine what op needs to be from the value
 *	 7.	Pop the value on top of the first stack
 *	 8. Push the value resulting from executing unload using the second stack and previously determined op
 *	 9. Go back to step 3 but use the next character in the collection
 *	 10.Return the value from popping the first stack
 *
 * STACK OF CHOICE: LLStack by Mr. Brown (library/hw32-stack version)
 * b/c LLStack's methods have the most efficient runtimes (constant for all of them)
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
	  Stack<String> stack1 = new LLStack();
	  Stack<String> stack2 = new LLStack();
	  int op = 0;
	  for( String s: expr.split( "\\s+" ) ) {
		  if ( !s.equals( ")" ) )
			  stack1.push( s );
		  else {
			  stack2 = new LLStack();
			  stack2.push( ")" );
			  while( !stack1.peek().equals( "(" ) ) {
				  stack2.push( stack1.pop() );
			  }
			  if ( stack2.peek().equals( "+" ) )
				  op = 1;
			  else if ( stack2.peek().equals( "-" ) )
				  op = 2;
			  else
				  op = 3;
			  stack2.pop();
			  stack1.pop();
			  stack1.push( unload( op, stack2 ) );
		  }
	  }
	  return stack1.pop();
  }//end evaluate()

  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers ) 
  {
	  int retVal = Integer.parseInt( numbers.pop() );
	  while( !numbers.isEmpty() ) {
		  if ( numbers.peek().equals( ")" ) )
			  break;
		  else if ( op < 2 )
			  retVal += Integer.parseInt( numbers.pop() );
		  else if ( op < 3 )
			  retVal -= Integer.parseInt( numbers.pop() );
		  else
			  retVal *= Integer.parseInt( numbers.pop() );
	  }
	  return Integer.toString( retVal );
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
