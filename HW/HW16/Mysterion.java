//	Andrew Shao
//	APCS2 pd2
//	HW16 -- About Face
//	2018-03-08R

public class Mysterion {
	
	/***
	 *	divideSort
	 *
	 *	arr				: array being operated on
	 *	lower 			: the lower bound index
	 *	upper			: the upper bound index
	 *	dividerIndex	: the index of the value acting as the divider
	 *
	 *	divideSort rearranges the elements of integer array arr so that a subarray of arr is an array x, 
	 *	where the elements of x are the elements of arr between (inclusive) arr[lower] and arr[upper - 1]
	 *	sorted into two groups divided by a divider value.	 
	 *	The values in the group to the left of the divider are all less than the divider
	 *	and the values to the right are all greater than the divider.
	***/
	
	public static int divideSort(int[] arr, int lower, int upper, int dividerIndex) {
		
		int divider = arr[dividerIndex];
		
		int temp = arr[dividerIndex];
		arr[dividerIndex] = arr[upper];
		arr[upper] = temp;
		
		int s = lower;
		
		for(int i = lower; i < upper; i ++) {
			if(arr[i] < divider) {
				temp = arr[s];
				arr[s] = arr[i];
				arr[i] = temp;
				s += 1;
			}
		}
		
		temp = arr[upper];
		arr[upper] = arr[s];
		arr[s] = temp;
		printArr(arr);
		return s;
		
	}
	
	public static void printArr(int[] arr) {
		
		String retStr = "[";
		for(int x: arr)
			retStr += x + ", ";
		retStr = retStr.substring(0,retStr.length() - 2) + "]";
		System.out.println(retStr);
		
	}
	
	public static void main (String args[]) {
		int[] arr = {9,4,6,7,12,1,2,5,10,3,11,8,0};
		System.out.println(divideSort(arr, 4, 10, 1));
	}
	
}