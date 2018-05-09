import java.util.PriorityQueue;
import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue
{
    private ArrayList _queue;

    public ArrayPriorityQueue()
    {
	_queue = new ArrayList();
    }

    public void add( Object o )
    {
	_queue.add( o );
    }

    public Object removeMin()
    {
	int index = 0;
	for( int i = 0; i < _queue.size(); i++ )
	    if ( ((String)_queue.get( i )).compareTo( (String)_queue.get( index ) ) < 0 )
		index = i;
	return _queue.remove( index );
    }

    public Object peekMin()
    {
	int index = 0;
	for( int i = 0; i < _queue.size(); i++ )
	    if ( ((String)_queue.get( i )).compareTo( (String)_queue.get( index ) ) < 0 )
		index = i;
	return _queue.get( index );
    }

    public boolean isEmpty()
    {
	return _queue.isEmpty();
    }
	
}
