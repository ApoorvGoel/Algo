package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

//The element can be used more then once
public class CombinationSum {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
/*		A.add(2);
		A.add(8);
		A.add(4);
		A.add(6);
		
		Collections.sort(A);*/
		A.add(1);
		A.add(2);
		System.out.println(A);
		System.out.println(new CombinationSum().combinationSum(A,8));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<>();
		TreeSet<Integer> ts = new TreeSet<>(A);
		A.clear();
		A.addAll(ts);
		findNumbers(result,al,A,B,0);
		return result;
	}

	void findNumbers(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> r, ArrayList<Integer> A, int sum, int index) {
		if (sum < 0) {
			return;
		}

		if (sum == 0) {
			ArrayList<Integer> res = new ArrayList<>(r);
			result.add(res);
			return;
		}

		while (index < A.size() && (sum - A.get(index) >= 0)) {
			r.add(A.get(index));
			findNumbers(result,r,A,sum-A.get(index),index);
			index++;
			r.remove(A.get(index-1));
		}
	}
}
