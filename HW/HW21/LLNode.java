/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
	private String cargo;
	private LLNode next;

    // constructor 	
	public LLNode( String s, LLNode n )
	{
		cargo = s;
		next = n;
	}

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
		return cargo;
    }

    public LLNode getNext()
    {
		return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String s )
    {
		String retStr = getCargo();
		cargo = s;
		return retStr;
    }

    public LLNode setNext( LLNode n )
    {
		LLNode retNode = getNext();
		next = n;
		return retNode;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
		return cargo + ", " + next;
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
		LLNode node0, node1, node2;
		node0 = new LLNode( "nunu", null );
		node1 = new LLNode( "challenger", node0 );
		node2 = new LLNode( "consume", null );
		
		System.out.println( "node0: " + node0 );
		System.out.println( "node1: " + node1 );
		System.out.println( "node2: " + node2 + "\n" );
		
		//Accessor Tests
		System.out.println( "Accessor Tests\nnode0.getCargo(): " + node0.getCargo() );
		System.out.println( "node0.getNext(): " + node0.getNext() );
		System.out.println( "node1.getCargo(): " + node1.getCargo() );
		System.out.println( "node1.getNext(): " + node1.getNext() + "\n" );
		
		//Mutator Tests
		System.out.println( "Mutator Tests\nnode1.setCargo( \"report\" ): " + node1.setCargo( "report" ) );
		System.out.println( "node1: " + node1 );
		
		System.out.println( "node1.setNext( node2 ): " + node1.setNext( node2 ) );
		System.out.println( "node2: " + node1 );
    }//end main

}//end class LLNode
