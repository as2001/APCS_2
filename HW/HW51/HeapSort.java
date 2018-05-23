//	Andrew Shao
//	APCS2 pd2
//	HW51 -- Heaping Piles of Sordidness
//	2018-05-21M

/*****************************************************
 * class HeapSort
 * Implements Heap sort, sorting using heaps
 *****************************************************/

public class HeapSort
{
	
	/*****************************************************
	 * int[] heapSort(int[])
	 * Uses heaps to sort input array
	 * Returns array of integers that is the input array sorted
	 *****************************************************/
	public static int[] heapSort( int[] input )
	{
		ALHeap tmp = new ALHeap();
		for( int element: input )
			tmp.add( element );
		int[] retArr = new int[input.length];
		for( int x = 0; x < retArr.length; x ++ )
			retArr[x] = tmp.removeMin();
		return retArr;
	}
	
	
	//main method for testing
	public static void main( String args[] )
	{
		int[] arr = {7, 1, 5, 12, 3};
		
		System.out.print( "array: [");
		for( int x: arr )
			System.out.print( x + " " );
		System.out.print( "]\n");
		
		arr = heapSort( arr );//sort it
		
		System.out.print( "sorted array: [" );
		for( int x: arr )
			System.out.print( x + " " );
		System.out.print( "]\n");
	}//end main()
	
}//end class HeapSort