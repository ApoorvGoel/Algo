package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

//The element can be used only once
public class CombinationalSum2 {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(2);
		A.add(8);
		A.add(4);
		A.add(6);
		A.add(6);

		// Collections.sort(A);
		// System.out.println(A);
		System.out.println(new CombinationalSum2().combinationSum(A, 8));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<>();
		// TreeSet<Integer> ts = new TreeSet<>(A);
		// A.clear();
		// A.addAll(ts);
		Collections.sort(A);
		findNumbers(result, al, A, B, 0);
		return result;
	}

	void addIfNeeded(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> r) {
		if (result.size() == 0) {
			ArrayList<Integer> res = new ArrayList<>(r);
			result.add(res);
			return;
		}
		ArrayList<Integer> res = result.get(result.size() - 1);
		if (res.size() == r.size()) {
			int i = 0;
			while (i < r.size() && res.get(i) == r.get(i)) {
				i++;
			}
			if (i == res.size())
				return;
		}
		res = new ArrayList<>(r);
		result.add(res);
		return;
	}

	void findNumbers(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> r, ArrayList<Integer> A, int sum, int index) {
		if (sum < 0) {
			return;
		}

		if (sum == 0) {
			addIfNeeded(result,r);
			return;
		}

		while (index < A.size() && (sum - A.get(index) >= 0)) {
			r.add(A.get(index));
			findNumbers(result, r, A, sum - A.get(index), ++index);
			r.remove(A.get(index - 1));
		}
	}
}
