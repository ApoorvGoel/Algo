package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SetZeroesWithoutExtraSpace {
	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(0);
		a1.add(1);
		a.add(a1);
		a1 = new ArrayList<>();
		a1.add(1);
		a1.add(1);
		a1.add(1);
		a.add(a1);
		a1 = new ArrayList<>();
		a1.add(1);
		a1.add(1);
		a1.add(1);
		a.add(a1);
		System.out.println(a);
		setZeroes(a);
		System.out.println(a);

	}

	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int row = a.size();
		int col = a.get(0).size();
		int row1 = 1;
		int col1 = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int data = a.get(i).get(j);
				if (data == 0) {
					if (i == 0) {
						row1 = 0;
					}
					if (j == 0) {
						col1 = 0;
					}
					a.get(i).set(0, 0);
					a.get(0).set(j, 0);
				}
			}
		}

		for (int i = 1; i < row; i++) {
			if (a.get(i).get(0) == 0) {
				for (int j = 0; j < col; j++) {
					a.get(i).set(j, 0);
				}
			}
		}
		for (int j = 1; j < col; j++) {
			if (a.get(0).get(j) == 0) {
				for (int i = 0; i < row; i++) {
					a.get(i).set(j, 0);
				}
			}
		}
		if (row1 == 0) {
			for (int j = 0; j < col; j++) {
				a.get(0).set(j, 0);
			}
		}

		if (col1 == 0) {
			for (int j = 0; j < row; j++) {
				a.get(j).set(0, 0);
			}
		}
	}
}
