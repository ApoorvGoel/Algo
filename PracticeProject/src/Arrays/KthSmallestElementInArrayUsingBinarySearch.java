package Arrays;

import java.util.List;
import java.util.Collections;

public class KthSmallestElementInArrayUsingBinarySearch {

	public static void main(String[] args) {

	}
	//nlogk approach with o(1) extra space
	public int kthsmallest(final List<Integer> A, int k) {

		if (k > A.size())
			return -1;

		int lo = Collections.min(A);
		int hi = Collections.max(A);

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int countLess = 0, countEqual = 0;

			for (int i = 0; i < A.size(); ++i) {
				if (A.get(i) < mid)
					++countLess;
				else if (A.get(i) == mid)
					++countEqual;
				if (countLess >= k)
					break;
			}

			if (countLess < k && countLess + countEqual >= k)
				return mid;
			else if (countLess >= k)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;
	}
}
