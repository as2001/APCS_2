//	Toot Toot Cabbage: Bill Ni, Rubin Peco, Andrew Shao
//	APCS2 pd2
// 	HW03 -- I Am Still Searching
//	2018-02-02F

/***
*	Start with the value at the top right corner.
*	If the current value is the desired value, return its location.
*	If the current value is less than the desired value, go one row down.
*	If the current value is greater than the desired value, go one coloumn to the left.
*	If the bottom left corner value is reached and is unequal to the desired value, 
*	the desired value must not be present in the matrix.
***/

public class MatrixFinder {
	
	public static String linSearch(int[][] matrix, int desiredValue) {
		int currentRow = 0;
		int currentColumn = matrix.length - 1;

		String retString = "(-1, -1)";

		while (currentColumn >= 0 && currentRow < matrix.length) {
			if (matrix[currentRow][currentColumn] == desiredValue) {
				retString = "(" + currentRow + ", " + currentColumn + ")";
				break;
			}
			else if (matrix[currentRow][currentColumn] < desiredValue)
				currentRow++;
			else
				currentColumn--;
		}

		return retString;
	}
	
	public static void printMatrix(int[][] matrix) {
		System.out.print("\n");
		for (int[] row: matrix) {
			System.out.print("| ");
			for (int value: row)
				System.out.print(value + " ");
			System.out.print("|\n");
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[1][1];
		matrix[0][0] = 100;
		System.out.print("matrix:");
		printMatrix(matrix);
		System.out.println(" linSearch(matrix,100) returns: " + linSearch(matrix, 100) + "\n");
		
		matrix = new int[3][3];
		for(int i = 0; i < 9; i ++)
			matrix[i / 3][i % 3] = i;
		System.out.print("matrix:");
		printMatrix(matrix);
		for(int i = 0; i < 10; i ++)
			System.out.println(" linSearch(matrix," + i + ") returns: " + linSearch(matrix, i));
	}
}
