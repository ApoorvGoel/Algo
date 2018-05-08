package Hashing;

import java.util.HashMap;

public class FractionalToDecimal {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(-2147483648));
		System.out.println(new FractionalToDecimal().fractionToDecimal(-2147483648, -1));
	}

	// Correct Solution--
	public String fractionToDecimal(int A, int B) {
		if (A == 0)
			return "0";
		if (B == 0)
			return "";

		StringBuilder result = new StringBuilder();
		if ((A < 0 && B > 0) || (A > 0 && B < 0))
			result.append("-");

		long remainder;
		long numerator = A;
		long denominator = B;
		// In this solution we are not using Math.abs directly because, Math.abs
		// gives wrong result for Integer.MIN_VALUE as it's return type is int.
		// So we firt converted into long and then used the same
		// numerator = (numerator < 0) ? (numerator * (-1)) : numerator;
		// denominator = (denominator < 0) ? (denominator * (-1)) : denominator;

		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		long res = numerator / denominator;

		result.append(res);

		remainder = (numerator % denominator) * 10;

		if (remainder == 0) {
			return result.toString();
		}
		result.append(".");
		HashMap<Long, Integer> hm = new HashMap<>();
		while (remainder != 0) {
			if (hm.containsKey(remainder)) {
				int index = hm.get(remainder);
				String part1 = result.substring(0, index);
				String part2 = result.substring(index, result.length());
				return part1 + "(" + part2 + ")";
			}
			hm.put(remainder, result.length());
			res = remainder / denominator;
			result.append(res);
			remainder = (remainder % denominator) * 10;
		}

		return result.toString();
	}

}
