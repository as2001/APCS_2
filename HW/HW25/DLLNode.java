//	Andrew Shao
//	APCS2 pd2
//	HW24a -- On the DLL
//	2018-03-26M

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 *****************************************************/

public class DLLNode<T> 
{
  private T _cargo;    //cargo may only be of type T
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  //YOUR IMPLEMENTATION HERE...
  
  //CONSTRUCTOR
  public DLLNode( T cargo, DLLNode next, DLLNode prev )
  {
	setCargo( cargo );
	setNext( next );
	setPrev( prev );
  }
  
  //ACCESSORS
  public T getCargo() 
  {
	return _cargo;
  }
  
  public DLLNode getNext()
  {
	return _nextNode;
  }
  
  public DLLNode getPrev()
  {
	return _prevNode;
  }
  
  //MUTATORS
  public T setCargo( T newVal )
  {
	T retVal = this.getCargo();
	_cargo = newVal;
	return retVal;
  }
  
  public DLLNode setNext( DLLNode newVal )
  {
	DLLNode retVal = this.getNext();
	_nextNode = newVal;
	return retVal;
  }
  
  public DLLNode setPrev( DLLNode newVal )
  {
	DLLNode retVal = this.getPrev();
	_prevNode = newVal;
	return retVal;
  }
  
  public String toString()
  {
	return (String) this.getCargo();
  }
  
  public static void main( String args[] )
  {
	DLLNode first = new DLLNode( "challenger", null, null );	
	first.setPrev( new DLLNode( "bronze", first, null ) );
	first = first.getPrev();
	first.getNext().setNext( new DLLNode( "nunu", null, first.getNext() ) );
	
	while( first != null ) {
	  System.out.println( first );
	  first = first.getNext();
	}
  }

}//end class DLLNode
