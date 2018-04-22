package Spiral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EntryPoint {

	public static void main(String[] args) {

		/*
		 * Scanner s = new Scanner(System.in);
		 * 
		 * int n = s.nextInt();
		 * 
		 * ArrayList<Integer> ar = new ArrayList<Integer>(); for (int i = 0; i <
		 * n; i++) { ar.add(s.nextInt()); }
		 */

		int[][] a2 = { { 1,3,4 }};
		List<ArrayList<Integer>> a1 = new ArrayList<ArrayList<Integer>>();

		for (int[] is : a2) {
			ArrayList<Integer> aIn = new ArrayList<Integer>();
			for (int i : is) {
				aIn.add(i);
			}
			a1.add(aIn);
		}
		System.out.println(a1);
		System.out.println(spiralOrder(a1));
	}

	public static ArrayList<Integer> spiralOrder(
			final List<ArrayList<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int u = 0;
		int l = 0;
		int d = a.size() - 1;
		int r = a.get(0).size() - 1;

		int i = 0;
		int j = 0;
		int k = 0;
		int f = 0;

		int size = (d + 1) * (r + 1);
		// System.out.println(size);
		int si = 3;

		while (l <= r && u <= d) {
			si = si - 1;
			for (i = l; i <= r; i++) {
				result.add(a.get(u).get(i));
			}
			System.out.println(result);
			u = u + 1;
			for (j = u; j <= d; j++) {
				result.add(a.get(j).get(r));
			}
			System.out.println(result);
			r = r - 1;
			for (k = r; k >= l && u<=d; k--) {
				result.add(a.get(d).get(k));
			}
			System.out.println(result);
			d = d - 1;
			for (f = d; f >= u && l<=r; f--) {
				result.add(a.get(f).get(l));
			}
			System.out.println(result);

			l = l + 1;
		}
		return result;
	}
}
