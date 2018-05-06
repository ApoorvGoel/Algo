package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(101);
		A.add(103);
		A.add(106);
		A.add(109);
		A.add(158);
		A.add(164);
		A.add(182);
		A.add(187);
		A.add(202);
		A.add(205);
		A.add(2);
		A.add(3);
		A.add(32);
		A.add(57);
		A.add(69);
		A.add(74);
		A.add(81);
		A.add(99);
		A.add(100);
		System.out.println(new RotatedSortedArraySearch().search(A, 202));
	}

	public int search(final List<Integer> a, int b) {
		int pivot = searchPivot(a, 0, a.size() - 1);
		if (pivot == -1)
			return binarySearch(a, b, 0, a.size() - 1);
		if (b == a.get(pivot))
			return pivot;
		if (b < a.get(0)) {
			return binarySearch(a, b, pivot + 1, a.size() - 1);
		}
		return binarySearch(a, b, 0, pivot - 1);

	}

	public int binarySearch(List<Integer> a, int k, int left, int right) {
		if (left == right) {
			if (a.get(left) == k) {
				return left;
			}
			return -1;
		}
		if (left > right)
			return -1;

		int mid = (left + right) / 2;
		if (a.get(mid) == k)
			return mid;
		if (a.get(mid) < k) {
			return binarySearch(a, k, mid + 1, right);
		}
		return binarySearch(a, k, left, mid - 1);
	}

	public int searchPivot(List<Integer> a, int left, int right) {
		if (left >= right)
			return -1;
		int mid = (left + right) / 2;
		if ((mid + 1) < a.size())
			if (a.get(mid) > a.get(mid + 1))
				return mid + 1;
		if ((mid - 1) >= 0)
			if (a.get(mid) < a.get(mid - 1))
				return mid;
		if (a.get(mid) > a.get(right)) {
			return searchPivot(a, mid + 1, right);
		}
		return searchPivot(a, left, mid - 1);
	}
}
