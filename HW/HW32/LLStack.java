//	Andrew Shao
//	APCS2 pd2
//	HW32 -- Leon Leonwood Stack
//	2018-04-12R

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>
{
	private LinkedList<PANCAKE> _stack;
	
	public LLStack()
	{
		_stack = new LinkedList<PANCAKE>();
	}
	
	public boolean isEmpty()
	{
		return _stack.isEmpty();
	}
	
	public PANCAKE peek()
	{
		return _stack.getFirst();
	}
	
	public PANCAKE pop()
	{
		return _stack.removeFirst();
	}
	
	public void push( PANCAKE x )
	{
		_stack.addFirst( x );
	}
	
	public static void main( String args[] )
	{
		LLStack<String> s = new LLStack();
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