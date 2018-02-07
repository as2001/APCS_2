//	Andrew Shao
//	APCS2 pd2
//	HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
//	2018-02-07W

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:  
  If the array is of length 1, return the array.
  If it is not, split the array into 2 smaller arrays, mergesort each array,
  and then return the array that results from merging the 2 smaller, sorted arrays.

  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      int[] retList = new int[a.length + b.length];
	  int aPos = 0, bPos = 0;
	  for(int x = 0; x < retList.length; x ++) {
		  if(aPos < a.length && bPos < b.length) {
			  if(a[aPos] < b[bPos]) {
				  retList[x] = a[aPos];
				  aPos ++;
			  }
			  else {
				  retList[x] = b[bPos];
				  bPos ++;
			  }
		  }
		  else if(aPos < a.length) {
			  retList[x] = a[aPos];
			  aPos ++;
		  }
		  else {
			  retList[x] = b[bPos];
			  bPos ++;
		  }
	  }
      return retList;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
	if(arr.length == 1)
		return arr;
	else {
		int[] a = new int[arr.length / 2];
		int[] b = new int[arr.length - a.length];
		for(int x = 0; x < a.length; x ++)
			a[x] = arr[x];
		for(int x = 0; x < b.length; x ++)
			b[x] = arr[x + a.length];
		return merge(sort(a), sort(b));
	}
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr3: ");
      printArray( merge(arr4,arr3) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
