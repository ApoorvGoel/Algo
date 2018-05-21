package greedy;

import java.util.ArrayList;

public class HighestProduct {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add( 3);
		A.add( 5);
		A.add( 2);
		A.add( 8);
		A.add( 0);
		A.add( -1);
		A.add( -3 );
		System.out.println(new HighestProduct().maxp3(A));
	}

	public int maxp3(ArrayList<Integer> A) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < A.size() - 1; j++) {
				if (A.get(j) > A.get(j + 1)) {
					swap(A, j, j+1);
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = i; j < A.size(); j++) {
				if (A.get(i) > A.get(j)) {
					swap(A, i, j);
				}
			}
		}
		long maxp = 1;
		if (A.get(A.size() - 1) < 0) {
			maxp = A.get(A.size() - 1) * A.get(A.size() - 2) * A.get(A.size() - 3);
			return (int) maxp;
		} else if (A.get(0) < 0 && A.get(1) < 0) {
			long temp1 = A.get(0) * A.get(1);
			long temp2 = A.get(A.size() - 3) * A.get(A.size() - 2);
			maxp = (temp1 > temp2) ? temp1 * A.get(A.size() - 1) : temp2 * A.get(A.size() - 1);
		} else {
			maxp = A.get(A.size() - 1) * A.get(A.size() - 2) * A.get(A.size() - 3);
		}

		return (int) maxp;
	}

	void swap(ArrayList<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
}
