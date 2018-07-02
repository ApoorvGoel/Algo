package dp;

import java.util.HashMap;

public class Stairs {

	public static void main(String[] args) {
		System.out.println(new Stairs().climbStairs(7));
	}

	public int climbStairs(int A) {
		if (A == 0 || A == 1) {
			return 1;
		}
		if (!hm.containsKey(A - 1)) {
			hm.put(A - 1, climbStairs(A - 1));
		}
		if (!hm.containsKey(A - 2)) {
			hm.put(A - 2, climbStairs(A - 2));
		}
		
		return hm.get(A-1)+hm.get(A-2);
	}

	HashMap<Integer, Integer> hm = new HashMap<>();

}
