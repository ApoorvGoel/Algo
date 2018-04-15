package String;

public class SubStringLocation {

	public static void main(String[] args) {
		System.out.println(new SubStringLocation().strStr("b", "b"));
		
	}

	public int strStr(final String A, final String B) {
		if (A == null || B == null || A == "" || B == "")
			return -1;

		if (A.length() < B.length())
			return -1;

		if (A.length() == B.length()) {
			int i = 0;
			while (i < A.length()) {
				if (A.charAt(i) != B.charAt(i))
					return -1;
				i++;
			}
			return 0;
		}
		int k = 0;
		int j = 0;
		for (int i = 0; i < A.length(); i++) {
			k = i;
			while (j < B.length()&&i<A.length()) {
				if (B.charAt(j) != A.charAt(i)) {
					break;
				}
				j++;
				i++;
			}
			if (j == B.length())
				return k;

			j = 0;
			i = k;
		}

		return -1;

	}
}
