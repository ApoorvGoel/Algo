package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {
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
		ArrayList<index> all = new ArrayList<index>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (a.get(i).get(j) == 0) {
					index in = new index();
					in.i = i;
					in.j = j;
					all.add(in);
				}
			}
		}

		for (index index : all) {
			List<Integer> rowL = a.get(index.i);
			for (int r = 0; r < col; r++) {
				rowL.set(r, 0);
			}
			for (int c = 0; c < row; c++) {
				rowL = a.get(c);
				rowL.set(index.j, 0);
			}
		}
	}
}

class index {
	int i;
	int j;
}