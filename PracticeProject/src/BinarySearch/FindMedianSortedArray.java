package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedianSortedArray {

	public static void main(String[] args) {

		ArrayList a = new ArrayList<>();
		a.add(-50);
		a.add(-41);
		a.add(-40);
		a.add(-19);
		a.add(5);
		a.add(21);
		a.add(28);

		ArrayList b = new ArrayList<>();
		b.add(-50);
		b.add(-21);
		b.add(-10);
		System.out.println(findMedianSortedArrays(a, b));
	}

	static double medianSortedArray(List<Integer> a) {
		if (a.size() % 2 == 0) {
			int mid = a.get(a.size() / 2);
			int mid2 = a.get((a.size() / 2) + 1);
			return (mid + mid2) / 2.0;
		}
		return a.get((a.size() / 2));

	}

	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		if (a.size() == 0 && b.size() == 0) {
			return 0;
		}
		if (a.size() == 0) {
			return medianSortedArray(b);
		} else if (b.size() == 0) {
			return medianSortedArray(a);
		}
		int totalEle = a.size() + b.size();
		int desiredPositon = 0;
		if (totalEle % 2 == 0)
			desiredPositon = (totalEle) / 2;
		else
			desiredPositon = ((totalEle) / 2) + 1;
		System.out.println(desiredPositon);

		int min = (a.get(0) < b.get(0)) ? a.get(0) : b.get(0);
		int max = (a.get(a.size() - 1) > b.get(b.size() - 1)) ? a.get(a.size() - 1) : b.get(b.size() - 1);
		int mid = (min + max) / 2;
		int i = 0;
		int j = 0;

		while (i < a.size() && j < b.size() && min <= max) {
			System.out.println(min + " " + max);
			mid = (min + max) / 2;
			System.out.println(mid);
			i = Collections.binarySearch(a, mid);
			j = Collections.binarySearch(b, mid);
			System.out.println(i + " " + j);

			if (i < 0) {
				i = -i;
				i--;
			}
			if (j < 0) {
				j = -j;
				j--;
			}

			System.out.println(i + " " + j);
			if ((desiredPositon) == (i + j)) {
				break;
			}
			if ((desiredPositon) > (i + j)) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(mid);

		i = Collections.binarySearch(a, mid);
		j = Collections.binarySearch(b, mid);

		if (i < 0 && j < 0) {
			i = -i;
			j = -j;
			if (i == a.size()) {
				mid = b.get(j);
			} else if (j == b.size()) {
				mid = a.get(i);
			} else {
				i--;
				j--;
			}
		}

		return 0.0;
	}
}
