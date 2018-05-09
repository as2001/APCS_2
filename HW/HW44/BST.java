//	Andrew Shao
//	APCS2 pd2
//	HW44 -- Prune Your Tree
//	2018-05-03R

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

import java.util.NoSuchElementException;

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
		// root value is target
		if ( currNode.getValue() == target )
			return currNode;
		// target should be left of root
		if ( currNode.getValue() > target ) {
			// target not present
			if ( currNode.getLeft() == null )
				return null;
			// recurse on left subtree
			return search( target, currNode.getLeft() );
		}
		// target not present
		if ( currNode.getRight() == null )
			return null;
		// recurse on right subtree
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
			return -1; // account for extra count on height
		// takes higher height of left or right subtree and adds 1
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
		// argument null
		if ( currNode == null )
			return 0;
		// sum of recursing left and right side
		int tmp = numLeaves( currNode.getLeft() ) + numLeaves( currNode.getRight() );
		// node is leaf
		if ( tmp == 0 )
			return 1;
		// not leaf
		return tmp;
	}
	

    /*****************************************************
     * int remove(int)
     * removes node from tree while maintaing groot
     *****************************************************/
    public int remove( int target )
    {
      /*** YOUR IMPLEMENTATION HERE ***/
	  TreeNode tmp, newNode, repNode;
	  newNode = tmp = _root;
	  int pos = 0; // for use in determining left or right for helper remove
	  // iterates so tmp points to target noed
	  while( tmp.getValue() != target ) {
		  newNode = tmp; // if target isn't root value newNode will point to parent of target node
		  if ( tmp.getValue() > target ) {
			  tmp = tmp.getLeft();
			  pos = 0;
		  }
		  else {
			  tmp = tmp.getRight();
			  pos = 1;
		  }
	  }
	  // target node with 0 or 1 child removal
	  if ( tmp.getLeft() == null || tmp.getRight() == null ) {
		  // target node is not root
		  if ( tmp != _root ) {
			  remove( newNode, pos );
		  }
		  // target is root
		  else if ( tmp.getLeft() == null )
			  _root = tmp.getRight();
		  else
			  _root = tmp.getLeft();
	  }
	  // target node with 2 child removal
	  else {
		  repNode = tmp;
		  newNode = tmp.getLeft();
		  pos = 0;
		  // iterates so newNode points to replacement value node
		  while( newNode.getRight() != null ) {
			  repNode = newNode; // repNode points to parent node of replacement node
			  newNode = newNode.getRight();
			  pos = 1;
		  }
		  tmp.setValue( newNode.getValue() ); // replaces target node value with replacement		  
		  remove( repNode, pos ); // removes replacement node
	  }
	  return target;
    }
	// helper method; 0 or 1 child removal for non-root node
	// removes left or right child node of currNode; 0 for left, 1 for right
	private void remove( TreeNode currNode, int pos )
	{
		if ( pos < 1 ) {
			if ( currNode.getLeft().getLeft() == null )
				currNode.setLeft( currNode.getLeft().getRight() );
			else
				currNode.setLeft( currNode.getLeft().getLeft() );
		}
		else {
			if ( currNode.getRight().getLeft() == null )
				currNode.setRight( currNode.getRight().getRight() );
			else
				currNode.setRight( currNode.getRight().getLeft() );
		}
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
	System.out.print( "number of leaves:\n" + arbol.numLeaves() );
	
    System.out.println( "\n-----------------------------");
	System.out.println( "0 removed:" );
	arbol.remove( 0 );	
	System.out.println( "2 removed:" );
	arbol.remove( 2 );
	System.out.print( "4 removed:" );
	arbol.remove( 4 );
	
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
	System.out.println( "search for 4:" );
	System.out.print( arbol.search( 4 ) );	
	
    System.out.println( "\n-----------------------------");
	System.out.println( "search for 5:" );
	System.out.print( arbol.search( 5 ).getValue() );
	
    System.out.println( "\n-----------------------------");
	System.out.print( "height:\n" + arbol.height() );
	
    System.out.println( "\n-----------------------------");
	System.out.print( "number of leaves:\n" + arbol.numLeaves() );
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
