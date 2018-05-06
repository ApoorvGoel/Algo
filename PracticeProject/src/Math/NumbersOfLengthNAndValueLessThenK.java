package Math;

import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThenK {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(5);
		A.add(3);
		A.add(7);
	}

	void populateSubsetsOfLengthB(ArrayList<Integer> A, int B) {

	}

	public int calcIntegerSize(int C) {
		String s = "" + C;
		return s.length();
	}

	public int countAllPossibleElementsOfLengthB(ArrayList<Integer> A, int B) {
		if (B == 1) {
			return A.size();
		}

		int mult = 1;
		if (A.get(0) == 0)
			mult = A.size() - 1;
		else
			mult = A.size();

		for (int i = 1; i < B; i++) {
			mult = mult * A.size();
		}

		return mult;
	}

	public int solve(ArrayList<Integer> A, int B, int C) {

		if (A.size() == 0 || B == 0 || C == 0)
			return 0;

		int cSize = calcIntegerSize(C);
		if (B > cSize)
			return 0;

		if (B < cSize)
			return countAllPossibleElementsOfLengthB(A, B);

		return 0;
	}
}
