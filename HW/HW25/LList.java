//	Andrew Shao
//	APCS2 pd2
//	HW25 -- Generically Speaking...
//	2018-03-27T

/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing data
 * new in v4, generic type
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{ 

  //instance vars
  private DLLNode _head, _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
	_tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------
    
  public boolean add( T newVal )
  {
	//if list is empty
	if ( size() < 1 )
		_head = new DLLNode( newVal, null, null );
	
	//if list only has 1 node
	else if ( size() < 2 ) {
		_tail = new DLLNode( newVal, null, _head );
		_head.setNext( _tail );
	}
	
	else {
		_tail = new DLLNode( newVal, null, _tail );
		_tail.getPrev().setNext(_tail);
	}
	
	_size++;
	return true;  
  }

    
  public T get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = (T) tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = (T) tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }
    

  //insert a node containing newVal at position index
  public void add( int index, T newVal ) {

    if ( index < 0 || index > size() )
	    throw new IndexOutOfBoundsException();

    if ( index == size() ) 
	    add( newVal );
	
	else if ( index < 1 ) {
		_head = new DLLNode( newVal, _head, null );
		_head.getNext().setPrev( _head );
	}
	
    else {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
			tmp = tmp.getNext();

	    //insert new node
		tmp.setNext( new DLLNode( newVal, tmp.getNext(), tmp ) );
		tmp.getNext().getNext().setPrev( tmp.getNext() );
	    
    }
	
	//increment size attribute
	_size++;
  }


  //remove node at pos index, return its cargo
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = (T) _head.getCargo();

	    //remove target node
	    _head = _head.getNext();
		if ( size() > 1 )//if list has more than 1 node
			_head.setPrev( null );
    }
	
	else if ( index == size() - 1 ) {
		retVal = (T) _tail.getCargo();
		
		_tail = _tail.getPrev();		
		_tail.setNext( null );
	}
	
    else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
			tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = (T) tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
		tmp.getNext().setPrev( tmp );
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );
	
	james.add(6,"lul");
    System.out.println( "...after add(6,lul): " );
    System.out.println( james );

    System.out.println( "...after remove last: " 
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
  }

}//end class LList


