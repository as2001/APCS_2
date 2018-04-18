//	Team Gatorade
//	Tim Marder and Andrew Shao
//	APCS2 pd2
//	HW36 -- Now Let’s Consider You Lot at Fake Terry’s
//	2018-04-18W

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
    private LLNode<T> _front;
    private LLNode<T> _end;
    private int _size;


  // default constructor creates an empty queue
  public RQueue() {

      _front = null;
      _end = null;
      _size = 0;
      
  }//end default constructor


  public void enqueue( T enQVal ) {

	LLNode<T> temp = new LLNode<T>( enQVal , null );

	if ( isEmpty() ) {
	    _front = temp;
	    _end = temp;
	}
	_end.setNext( temp );
	_end = _end.getNext();
	_size++;	    

    }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue() {

      if ( isEmpty() ) {
		  return null;
	  }
	  sample();
	  return peekFront();
      
  }//end dequeue()


  public T peekFront() {

	T rtrn = _front.getValue();
	_front = _front.getNext();
	
	if ( isEmpty() ) {
		_end = null;
	}
	_size--;
	
	return rtrn;
  
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo: Take the front value out of the queue and enqueue it back onto the end,
   * repeat this a randomly generated number of times.
   ******************************************/
  public void sample () {

	int thing = (int) (Math.random() * _size) - 1;
	
	for (int i = 0 ; i < thing ; i++) {
		enqueue( peekFront() );
	}
  
  }//end sample()


  public boolean isEmpty() {

	return _front == null;
  
  } //O(1)


    // print each node, separated by spaces
  public String toString() { 

	String result = "";
	LLNode<T> temp = _front;
	while ( temp != null ) {
		result += temp.getValue() + " ";
		temp = temp.getNext();
	}
	return result;
  
  }//end toString()



  //main method for testing
  public static void main( String[] args ) {

      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing..."); 
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()..."); 
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing..."); 
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing fr empty queue..."); 
      System.out.println( PirateQueue.dequeue() );

  }//end main

}//end class RQueue
