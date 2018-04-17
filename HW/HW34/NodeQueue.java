//	Andrew Shao
//	APCS2 pd2
//	HW34 -- The English Do Not Wait In Line
//	2018-04-16M

public class NodeQueue<Quasar> implements Queue<Quasar>{
	
	private LLNode<Quasar> _queue;
	
	public NodeQueue() {
		_queue = new LLNode<Quasar>( null, null );
	}
	
	public Quasar dequeue() {
		LLNode<Quasar> tmp = _queue;
		Quasar retVal;
		if ( tmp.getNext() == null ) {
			retVal = tmp.getValue();
			tmp.setValue( null );
		}
		else {
			while( tmp.getNext().getNext() != null )
				tmp = tmp.getNext();
			retVal = tmp.getNext().getValue();
			tmp.setNext( null );
		}			
		return retVal;
	}
	
	public void enqueue( Quasar x ) {
		if( _queue.getValue() == null )
			_queue.setValue( x );
		else
			_queue = new LLNode<Quasar>( x, _queue ); 
	}
	
	public boolean isEmpty() { return _queue.getValue() == null; }
	
	public Quasar peekFront() {
		LLNode<Quasar> tmp = _queue;
		while( tmp.getNext() != null )
			tmp = tmp.getNext();
		return tmp.getValue();
	}
	
	public static void main( String args[] ) {
		NodeQueue<Integer> queue = new NodeQueue<Integer>();
		System.out.println( "is queue empty: " + queue.isEmpty() + "\n" );
		for( int x = 1; x < 4; x ++ ){
			queue.enqueue( x );
			System.out.println( "front of queue after enqueuing " + x + ": " + queue.peekFront() );
		}
		System.out.println();
		while( !queue.isEmpty() )
			System.out.println( "value returned from dequeuing: " + queue.dequeue() );
	}
}