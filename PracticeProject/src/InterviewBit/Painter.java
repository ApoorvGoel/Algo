package InterviewBit;

import java.util.ArrayList;

/*
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time 
 * a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter
 * will only paint contiguous sections of board.
 

        2 painters cannot share a board to paint. That is to say, a board
        cannot be painted partially by one painter, and partially by another.
        A painter will only paint contiguous boards. Which means a
        configuration where painter 1 paints board 1 and 3 but not 2 is
        invalid.

Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003

Example

Input : 
  K : 2
  T : 5
  L : [1, 10]

Output : 50

 */
public class Painter {
	public Painter() {
		// TODO Auto-generated constructor stub
	}

	static int getMax(int A[], int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] > max)
				max = A[i];
		}
		return max;
	}

	static int getSum(int A[], int n) {
		int total = 0;
		for (int i = 0; i < n; i++)
			total += A[i];
		return total;
	}

	static int getRequiredPainters(int A[], int n, int maxLengthPerPainter) {
		int total = 0, numPainters = 1;
		for (int i = 0; i < n; i++) {
			total += A[i];
			if (total > maxLengthPerPainter) {
				total = A[i];
				numPainters++;
			}
		}
		return numPainters;
	}

	static int partition(int A[], int n, int k) {
		int lo = getMax(A, n);
		int hi = getSum(A, n);

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int requiredPainters = getRequiredPainters(A, n, mid);
			if (requiredPainters <= k)
				hi = mid;
			else
				lo = mid + 1;
		}
		return lo;
	}

	// Driver code
	public static void main(String args[]) {
		//int arr[] = {9,  6, 7, 8, 1, 2, 3, 4, 5 };
		int arr[] = {1000000, 1000000 };
		// Calculate size of array.
		int n = arr.length;
		int k = 1;
		System.out.println(partition(arr, n, k));
	}
}
