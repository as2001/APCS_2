//	Andrew Shao
//	APCS2 pd2
//	HW17 -- So So Fast
//	2018-03-12M

/***
 *	To find yth smallest value in array of size n:
 *	1.	Start with a lower value of 0 and an upper value of n - 1
 *	2.	Partition the array with lower limit equal to the lower value and upper limit equal to upper value
 *		and pivot value of the element with lower value as the index.
 *	3.	If returned value is equal to y - 1 the pivot value is the yth smallest value.
 *		If returned value is greater than y - 1 lower the upper value to returned value - 1.
 *		Else raise the lower value to returned value + 1.
 *	4.	Go back to step 2 
 ***/
 
/***
 *	Algorithm runtime classification: O(n^2)
 *	Best case scenario: y = 0
 *		Runtime: O(n)
 *	Worst case scenario: array sorted in ascending order and y = n
 *		Runtime: O(n^2)
 ***/
 
public class FastSelect 
{
	

	public static void swap(int[] arr, int x, int y)
	{
		
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		
	}
	
	
	public static int partition(int[] arr, int lower, int upper, int pivot)
	{
		
		int pivotVal = arr[pivot];
		
		swap(arr, upper, pivot);
		
		int s = lower;
		
		for(int i = lower; i < upper; i ++)
			if(arr[i] < pivotVal) 
			{
				swap(arr, s, i);
				s += 1;
			}
		
		swap(arr, upper, s);
		
		return s;
		
	}
	
	
	public static int fastSelect(int[] arr, int n)
	{
		
		//int passCtr = 1;		
		int x = partition(arr, 0, arr.length - 1, 0);
		int lower = 0;
		int upper = arr.length - 1;
		
		while(x != n - 1)
		{
			if(x >= n)
				upper = x - 1;
			else
				lower = x + 1;			
			x = partition(arr, lower, upper, lower);
			//passCtr ++;
		}
		
		//System.out.println(passCtr);
		return arr[n - 1];
		
	}
	
	
	// builds array of size s with random values from 0 to maxVal with no duplicates
	public static int[] buildArray(int s, int maxVal) 
	{
		
		int[] retArr = new int[s];
		int x = (int)(Math.random() * maxVal);
		boolean isDuplicate = false;
		
		for(int i = 0; i < retArr.length; i++)
		{
			while(isDuplicate) 
			{				
				isDuplicate = false;
				x = (int)(Math.random() * maxVal);
				for(int y: retArr)
					if(x == y)
						isDuplicate = true;
			}
			retArr[i] = x;
			isDuplicate = true;
		}
		
		return retArr;
		
	}
	
	public static void shuffle(int[] d) 
	{
		
		int tmp;
		int swapPos;
		for(int i = 0; i < d.length; i++)
		{
			tmp = d[i];
			swapPos = i + (int)( (d.length - i) * Math.random() );
			swap( d, swapPos, i );
		}
		
	}
	
	
	public static void printArr(int[] arr) 
	{
		
		String retStr = "[";
		for(int x: arr)
			retStr += x + ", ";
		retStr = retStr.substring(0,retStr.length() - 2) + "]";
		System.out.print(retStr);
		
	}
	
	
	public static void main(String args[])
	{
		
		int[] arr = buildArray(12, 20);
		shuffle(arr);
		System.out.print("array: ");
		printArr(arr);
		System.out.println();
		
		for(int x = 1; x < 13; x ++)
		{
			System.out.println(x + "th smallest element in array: " + fastSelect(arr, x));
		}
		
		//	best case
		int[] best = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.print("\nbest case array: ");
		printArr(best);
		System.out.println("\n1st smallest element in array: " + fastSelect(best, 1));
		
		//	worst case
		int[] worst = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.print("\nworst case array: ");
		printArr(worst);
		System.out.println("\n10st smallest element in array: " + fastSelect(worst, 10));
		
	}
	
	
}