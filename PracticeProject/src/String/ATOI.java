package String;

public class ATOI {

	public static void main(String[] args) {

		System.out.println(atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));
	}

	static int newAtoi(String A) {
		String A1 = A.trim();
		Long num = 0l;
		int i = 0;
		int sign = 1;
		if (A1.charAt(0) == '-') {
			i = 1;
			sign = -1;
		} else if (A1.charAt(0) == '+') {
			i = 1;
		}
		for (; i < A1.length(); i++) {
			Character c = A1.charAt(i);
			if (isNumeric(c)) {
				num = num * 10 + Character.getNumericValue(c);
			} else {
				break;
			}
		}

		try {
			String r = "" + num;
			return sign * Integer.parseInt(r);
		} catch (Exception ex) {
			return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
	}

	static int atoi(String A) {

		String A1 = A.trim();
		int num = 0;
		int i = 0;
		int sign = 1;
		if (A1.charAt(0) == '-') {
			i = 1;
			sign = -1;
		} else if (A1.charAt(0) == '+') {
			i = 1;
		}

		for (; i < A1.length(); i++) {
			Character c = A1.charAt(i);
			if (isNumeric(c)) {
				try {
					System.out.print(num);
					num = num * 10 + Character.getNumericValue(c);
					System.out.println("Update " + num);
				} catch (Exception Ex) {
					System.out.println("fattu");
					return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
			} else {
				break;
			}
		}

		try {

		} catch (Exception ex) {

		}
		return sign * num;

	}

	static boolean isNumeric(Character c) {
		return (c >= '0' && c <= '9');
	}
}
