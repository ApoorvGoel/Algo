package dp;

import java.util.ArrayList;

public class EqualAveragePartition {

	public static void main(String[] args) {
		String a = "a";
		a = a + "b";
	}

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
		if (A == null || A.size() == 0)
			return null;

		long total_sum = 0;
		for (Integer integer : A) {
			total_sum = total_sum + (long) integer;
		}
		long avg_total = total_sum / A.size();

		return null;
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
			addIfNeeded(result, r);
			return;
		}

		while (index < A.size() && (sum - A.get(index) >= 0) && result.size() == 0) {
			r.add(A.get(index));
			findNumbers(result, r, A, sum - A.get(index), ++index);
			r.remove(A.get(index - 1));
		}
	}

}
