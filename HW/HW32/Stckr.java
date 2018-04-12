//	Andrew Shao
//	APCS2 pd2
//	HW32 -- Leon Leonwood Stack
//	2018-04-12R

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
	// Stack<String> cakes = new ALStack<String>();
	Stack<String> cakes = new LLStack<String>();

	//"bronze jungle fail smite challenger nunu consume blue"
	System.out.println( "is cakes empty: " + cakes.isEmpty() + "\n" );
	
	//push tests
	cakes.push( "blue" );	
	System.out.println( "top value of cakes after pushing blue:\n" + cakes.peek() );	
	cakes.push( "consume" );	
	System.out.println( "top value of cakes after pushing consume:\n" + cakes.peek() );	
	cakes.push( "nunu" );
	System.out.println( "top value of cakes after pushing nunu:\n" + cakes.peek() );		
	cakes.push( "challenger" );
	System.out.println( "top value of cakes after pushing challenger:\n" + cakes.peek() );	
	cakes.push( "smite" );	
	System.out.println( "top value of cakes after pushing smite:\n" + cakes.peek() );	
	cakes.push( "fail" );	
	System.out.println( "top value of cakes after pushing fail:\n" + cakes.peek() );	
	cakes.push( "jungle" );	
	System.out.println( "top value of cakes after pushing jungle:\n" + cakes.peek() );	
	cakes.push( "bronze" );	
	System.out.println( "top value of cakes after pushing bronze:\n" + cakes.peek() );
	
	System.out.println( "\nis cakes empty: " + cakes.isEmpty() + "\n" );
	
	//pop tests
	for( int i = 0; i < 8; i ++ ){
		System.out.println( "top value of cakes: " + cakes.peek() );
		System.out.println( "value popped from cakes: " + cakes.pop() );
	}
	
	System.out.println( "\nis cakes empty: " + cakes.isEmpty() + "\n" );
	
    }//end main

}//end class

