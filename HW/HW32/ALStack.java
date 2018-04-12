//	Andrew Shao
//	APCS2 pd2
//	HW32 -- Leon Leonwood Stack
//	2018-04-12R

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>
{
	private ArrayList<PANCAKE> _stack;
	
	public ALStack()
	{
		_stack = new ArrayList();
	}
	
	public boolean isEmpty()
	{
		return _stack.isEmpty();
	}
	
	public PANCAKE peek()
	{
		return _stack.get( 0 );
	}
	
	public PANCAKE pop()
	{
		return _stack.remove( 0 );
	}
	
	public void push( PANCAKE x )
	{
		_stack.add( 0, x );
	}
	
	public static void main( String args[] )
	{
		ALStack<String> s = new ALStack();
		System.out.println( s.isEmpty() + "\n" );
		
		s.push( "smite" );
		
		System.out.println( s.peek() );
		s.push( "nunu" );
		
		System.out.println( s.peek() + "\n" );
		s.push( "challenger" );
		
		for( int i = 0; i < 3; i ++ ){
			System.out.println( s.peek() );
			System.out.println( s.pop() );
		}
	}
}