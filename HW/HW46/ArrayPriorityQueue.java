//	Andrew Shao
//	APCS2 pd2
//	HW46 -- Arrr, There Be Priorities Here Matey
//	2018-05-10R

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue
{
	
    private ArrayList<String> _queue;

    public ArrayPriorityQueue()
    {
	_queue = new ArrayList<String>();
    }

	// Runtime: O(1)
    public void add( String o )
    {
	_queue.add( o );
    }

	// Runtime: O(n)
    public String removeMin()
    {
	int index = 0;
	for( int i = 0; i < _queue.size(); i++ )
	    if ( _queue.get( i ).compareTo( _queue.get( index ) ) < 0 )
		index = i;
	return _queue.remove( index );
    }

	// Runtime: O(n)
    public String peekMin()
    {
	int index = 0;
	for( int i = 0; i < _queue.size(); i++ )
	    if ( _queue.get( i ).compareTo( _queue.get( index ) ) < 0 )
		index = i;
	return _queue.get( index );
    }

	// Runtime: O(1)
    public boolean isEmpty()
    {
	return _queue.isEmpty();
    }
	
	public static void main( String args[] )
	{
		ArrayPriorityQueue apq = new ArrayPriorityQueue();
		
		apq.add( "nunu" );
		apq.add( "challenged" );
		apq.add( "bronze" );
		apq.add( "challenger" );
		apq.add( "smite" );
		apq.add( "consume" ); 
		apq.add( "buff" );
		apq.add( "jungle" );		
		// bronze buff challenged challenger consume jungle nunu smite
		
		System.out.println( apq.peekMin() ); // bronze
		
		while( !apq.isEmpty() )
			System.out.print( apq.removeMin() + " " );			
	}
	
}
