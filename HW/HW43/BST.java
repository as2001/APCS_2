//	Andrew Shao
//	APCS2 pd2
//	HW43 -- BSTs is the Perfect Place for Shade
//	2018-05-02W

/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
   * default constructor
   *****************************************************/
  BST( )
  {
    _root = null;
  }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
      /*** YOUR IMPLEMENTATION HERE ***/
	  return search( target, _root );
    }
	private TreeNode search( int target, TreeNode currNode )
	{
		if ( currNode.getValue() == target )
			return currNode;
		if ( currNode.getValue() > target ) {
			if ( currNode.getLeft() == null )
				return null;
			return search( target, currNode.getLeft() );
		}
		if ( currNode.getRight() == null )
			return null;
		return search( target, currNode.getRight() );
	}


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
      /*** YOUR IMPLEMENTATION HERE ***/
	  return height( _root );
    }
	private int height( TreeNode currNode )
	{
		if ( currNode == null )
			return -1;
		if ( height( currNode.getLeft() ) > height( currNode.getRight() ) )
			return 1 + height( currNode.getLeft() );
		return 1 + height( currNode.getRight() );
		
	}


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
      /*** YOUR IMPLEMENTATION HERE ***/
	  return numLeaves( _root );
    }
	private int numLeaves( TreeNode currNode )
	{
		if ( currNode.getLeft() == null ) {
			if ( currNode.getRight() == null )
				return 1;
			return numLeaves( currNode.getRight() );
		}
		if ( currNode.getRight() != null )
			return numLeaves( currNode.getLeft() ) + numLeaves( currNode.getRight() );
		return numLeaves( currNode.getLeft() );
	}




  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 6 );
    arbol.insert( 5 );
    arbol.insert( 1 );
    arbol.insert( 3 );	
    arbol.insert( 0 );
    arbol.insert( 7 );
    arbol.insert( 8 );

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");
	System.out.println( "search for 9:" );
	System.out.print( arbol.search( 9 ) );	
	
    System.out.println( "\n-----------------------------");
	System.out.println( "search for 5:" );
	System.out.print( arbol.search( 5 ).getValue() );
	
    System.out.println( "\n-----------------------------");
	System.out.print( "height:\n" + arbol.height() );
	
    System.out.println( "\n-----------------------------");
	System.out.println( "number of leaves:\n" + arbol.numLeaves() );
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      <<< YOUR NEW TEST CALLS HERE >>>
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
