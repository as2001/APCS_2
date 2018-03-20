//	Andrew Shao
//	APCS2 pd2
//	HW21c -- Rockin' Through the Night
//	2018-03-20T

public class LList implements List 
{
	
	private LLNode node;
	
	public LList() {
		node = new LLNode( null, null );
	}
	
	public boolean add( String x )
	{
		if( node.getCargo() == null )
			node.setCargo( x );
		else
			node = new LLNode( x, node );
		return true;
	}
	
	public String get( int i )
	{
		LLNode currentN = node;
		for( int index = 0; index < i; index ++ )
			currentN = currentN.getNext();
		return currentN.getCargo();
	}
	
	public String set( int i, String x )
	{
		LLNode currentN = node;
		for( int index = 0; index < i; index ++ )
			currentN = currentN.getNext();
		String retStr  = get( i );
		currentN.setCargo( x );
		return retStr;
	}
	
	public int size()
	{
		int retInt = 0;
		if( node.getCargo() != null )
			retInt ++;
		LLNode currentN = node;
		while( currentN.getNext() != null ) {
			currentN = currentN.getNext();
			retInt ++;
		}
		return retInt;
	}
	
	public String toString()
	{
		return node.toString();
	}
	
	public static void main( String args[] )
	{
		LList list = new LList();
		System.out.println( "list size: " + list.size() );
		
		list.add( "challenger" );
		System.out.println( "list post-add: " + list );
		list.add( "nunu" );
		System.out.println( "list post-add: " + list );
		list.add( "consume" );
		System.out.println( "list post-add: " + list );
		list.add( "report" );
		System.out.println( "list post-add: " + list );
		
		list.set( 0, "bronze" );
		System.out.println( "list post-set: " + list );
		list.set( 2, "smite" );
		System.out.println( "list post-set: " + list );
		
		System.out.println( "list size: " + list.size() );
	}
	
}