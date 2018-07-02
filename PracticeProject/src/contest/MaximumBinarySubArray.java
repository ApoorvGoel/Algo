package contest;

import java.util.HashMap;
import java.util.LinkedList;

public class MaximumBinarySubArray {

	public static void main(String[] args) {
		//System.out.println(countOne(7));
		int[] a = new int[4];
		a[0]=1;
		a[1]=2;
		a[2]=4;
		a[3]=8;
		int[] d = new int[3];
		d[0]=7;
		d[1]=2;
		d[2]=5;
	
		//System.out.println(subArraySum(a,4,30));
		for (int i : solve(2,3,a,d)) {
		System.out.println(i);	
		}
	}

	public static int[] solve(int A, int B, int[] C, int[] D) {
		long[] countArray = new long[C.length];
		for (int i = 0; i < C.length; i++) {
			long count = countOne(C[i]);
			countArray[i] = count;
		}
		int[] resultArray = new int[D.length];
		for (int i = 0; i < D.length; i++) {
			resultArray[i]=subArraySum(countArray,countArray.length,D[i]);
		}

		return resultArray;
	}

	public static long countOne(int digit) {
		long count = 0;
		long temp=(long)digit;
		while (temp > 0) {
			count = (temp % 2 == 0) ? count : ++count;
			temp /= 2;
		}
		return count;
	}

	static int subArraySum(long arr[], int n, int sum) {
		// create an empty map
		HashMap<Long, Long> map = new HashMap<>();
		// Maintains sum of elements so far
		long curr_sum = 0;
		long min=Long.MAX_VALUE;
		for (long i = 0; i < n; i++) {
			// add current element to curr_sum
			curr_sum = curr_sum + arr[(int)i];
			// if curr_sum is equal to target sum
			// we found a subarray starting from index 0
			// and ending at index i
			if (curr_sum == sum) {
			//	System.out.println("Sum found between indexes 0 to" + i);
				//return;
				
				min=(min>(i+1))?i+1:min;
			//	System.out.println(min);
			}
			// If curr_sum - sum already exists in map
			// we have found a subarray with target sum
			if (map.containsKey(curr_sum - sum)) {
			//	System.out.println("Sum found between indexes " + (map.get(curr_sum - sum) + 1) + " to " + i);
				//return;
			//	System.out.println(min);
				//System.out.println(i+1-(map.get(curr_sum - sum) + 1));
				min=(min>(i+1-(map.get(curr_sum - sum) + 1)))?(i+1-(map.get(curr_sum - sum) + 1)):min;
			//	System.out.println(min);
			}
			map.put(curr_sum, i);
		}

		// If we reach here, then no subarray exists
		//System.out.println("No subarray with given sum exists");
		
		min=(min==Long.MAX_VALUE)?-1:min;
		return (int)min;
	}

}
