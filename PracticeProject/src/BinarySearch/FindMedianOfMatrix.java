package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMedianOfMatrix {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(5);
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		arr.add(al);

		al = new ArrayList<>();
		al.add(2);
		al.add(6);
		al.add(9);
		arr.add(al);
		al = new ArrayList<>();
		al.add(3);
		al.add(6);
		al.add(9);
		arr.add(al);

		arr.clear();

		al = new ArrayList<>();
		al.add(1);
		al.add(1);
		al.add(3);
		al.add(3);
		al.add(3);
		arr.add(al);

		System.out.println(findMedian(arr));
	}

	public static int findMedian(ArrayList<ArrayList<Integer>> A) {
		int rows = A.size();
		int cols = A.get(0).size();
		int i = 0;
		int desiredPlace = ((rows * cols) / 2) + 1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		while (i < rows) {
			temp = A.get(i).get(0);
			if (temp < min) {
				min = temp;
			}

			temp = A.get(i).get(cols - 1);
			if (temp > max)
				max = temp;
			i++;
		}

		int mid = 0;
		while (min < max) {
			i = 0;
			mid = (min + max) / 2;
			int place = 0;
			int placeInCurrentMatrix = 0;

			while (i < rows) {
				placeInCurrentMatrix = binarySearch(A.get(i), mid, 0, A.get(i).size() - 1);
				if (placeInCurrentMatrix < 0) {
					placeInCurrentMatrix = Math.abs(placeInCurrentMatrix) - 1;
				} else {
					temp = A.get(i).get(placeInCurrentMatrix);
					int j = 0;
					while (placeInCurrentMatrix < A.get(i).size() && temp == (int) A.get(i).get(placeInCurrentMatrix)) {
						placeInCurrentMatrix++;
					}
				}
				place = place + placeInCurrentMatrix;
				i++;
			}
			if (place < desiredPlace) {
				min = mid + 1;
			} else
				max = mid;
		}
		return min;
	}

	static int binarySearch(ArrayList<Integer> al, int element, int i, int j) {
		int temp = 0;
		if (i > j) {
			return -(i + 1);
		}
		int mid = (i + j) >>> 1;
		temp = al.get(mid);

		if (temp == element)
			return mid;
		if (temp > element)
			return (binarySearch(al, element, i, mid - 1));
		else
			return (binarySearch(al, element, mid + 1, j));
	}

}
