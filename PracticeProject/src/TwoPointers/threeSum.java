package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

import Spiral.EntryPoint;

public class threeSum {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-4);
		/*
		 * A.add(-5); A.add(1); A.add(4); A.add(-7); A.add(10); A.add(-7);
		 * A.add(0); A.add(7); A.add(3); A.add(0); A.add(-2); A.add(-5);
		 * A.add(-3); A.add(-6); A.add(4); A.add(-7); A.add(-8); A.add(0);
		 * A.add(4); A.add(9); A.add(4); A.add(1); A.add(-8); A.add(-6);
		 * A.add(-6); A.add(0); A.add(-9); A.add(5); A.add(3); A.add(-9);
		 * A.add(-5); A.add(-9); A.add(6); A.add(3); A.add(8); A.add(-10);
		 * A.add(1); A.add(-2); A.add(2); A.add(1); A.add(-9); A.add(2);
		 * A.add(-3); A.add(9); A.add(9); A.add(-10); A.add(0); A.add(-9);
		 * A.add(-2); A.add(7); A.add(0); A.add(-4); A.add(-3); A.add(1);
		 * A.add(6); A.add(-3);
		 */
		System.out.println(threeSumClosestFinal(A, 1));
	}

	public static int threeSumClosest(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			int s = 0;
			int l = A.size() - 1;
			for (int j = 0; j < A.size() && s < A.size() && l >= 0; j++) {
				if (j != i) {
					if ((A.get(i) + A.get(s) + A.get(l)) > B)
						l = (l == i) ? l - 2 : l - 1;
					else
						s = (s == i) ? s + 2 : s + 1;
				}
			}
			if (s < A.size() && l >= 0)
				if ((A.get(i) + A.get(s) + A.get(l)) < min)
					min = A.get(i) + A.get(s) + A.get(l);
		}

		return min;
	}

	public static int threeSumClosestDriver(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			int s = i + 1;
			int l = A.size() - 1;
			System.out.println("i=" + i);
			for (int j = i + 1; j < A.size() && s < A.size() && l >= 0 && s != l; j++) {
				System.out.println(A.get(i) + "+" + A.get(s) + "+" + A.get(l));
				System.out.println((A.get(i) + A.get(s) + A.get(l)));
				System.out.println((A.get(i) + A.get(s) + A.get(l)) >= B);
				if ((A.get(i) + A.get(s) + A.get(l)) >= B)
					l--;
				else
					s++;
			}
			if (s < A.size() && l >= 0)
				if ((A.get(i) + A.get(s) + A.get(l)) < B) {
					min = (B - (A.get(i) + A.get(s) + A.get(l))) > min ? min : (B - (A.get(i) + A.get(s) + A.get(l)));
				} else {
					min = ((A.get(i) + A.get(s) + A.get(l)) - B) > min ? min : ((A.get(i) + A.get(s) + A.get(l)) - B);
				}
		}
		return min;
	}

	public static int threeSumClosestFinal(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < A.size(); i++) {
			int j = i + 1;
			int l = A.size() - 1;
			while (j < l) {
				int sum = A.get(i) + A.get(j) + A.get(l);
				int diff = Math.abs(sum - B);

				if (diff == 0)
					return sum;

				if (diff < min) {
					min = diff;
					result = sum;
				}

				if (sum <= B) {
					j++;
				} else {
					l--;
				}

			}
		}
		return result;
	}
}
