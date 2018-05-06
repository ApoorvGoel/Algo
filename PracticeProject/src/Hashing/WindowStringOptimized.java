package Hashing;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class WindowStringOptimized {

	public static void main(String[] args) {
		System.out.println(new WindowStringOptimized().minWindow("j67yluuhZeBQ5WCYpPz0ff39V92gJaaGHb3onlwjh3SH2mllTHGLQ9W8QsDGVH1lbLqxgF1LssG2pkIpyUhE3XUrnnNvLVFthuVVjB0r1BnP4G1HgXTcWlEMf34yaqhiEtjydTweHwIcVTN2z4uOgIC0oluZf4TiF19Amliay9BVu9U1V9cE4VB453fFAEk08DgqDVERGhKXWpmY99De07dEyCjyfj8KoGpuEOOLAZFiykrwcXcB59NPc4sLTxDgrbSoUMQ2Uj5WIxFVE1wHBEy2szh8BqGSY1RqXnU2yXeFzQiHck0aEhkDiZqv5H6EEjjFPLye15hedHL89g1nvP4OAI7l28KeV7K4sV9CtNbHswHh9ZgXYxgGl9RdnFHwHznOYsaGv2A29xPJ31eGFqzufugkGIBcBynLYXJoJkST3nCDongOkPg9gBtmj5cmR5rpxu2MNL6soZu3UnoMeM19OzDZvV7Z989bpBZQTGL8qZ5Mom2yJUkDi11GS0DKQl2Gq1hAOXdje3qKnypbLVm3SUOo4kJsgnP2DuVhotnxMgOT0N8oayTrgGD0AHZiHfAV85alLTePLVItmtjQQQ5VhWRXbQODRklscZTYeL24t3JogADEN8YxPeFZgDhfnKWPebdL0g9mNpbH3gSyzIGIEV0B03nHZqnaARXWyhLRzeqIAAwpYc70Nd4vwzGSF1xjQNZT5yVp5KpBZPbGGd3xMD7QLLV6B2pDSDXdREFDpzfxjLuCnm45FziDlJtDFIj0y6oMRT0XLjtG25HG4gDqVxCRxIwfGxbCyByVeQBQGvMcbMmxWGXuJolneC8pxjvVvAnXi", "mGGgXcmFoAfmoVwBvXE2Jy4uZO2RAuoCQ"));
	}

	public void addCharToHashMap(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (hm.containsKey(s.charAt(i))) {
				counter c = hm.get(s.charAt(i));
				c.count += 1;
				hm.put(s.charAt(i), c);
			} else {
				counter c = new counter();
				c.count = 1;
				hm.put(s.charAt(i), c);
			}
		}
	}

	HashMap<Character, counter> hm = new HashMap<>();

	class counter {
		int count;
	}

	public HashMap<Character, counter> deepCopyHm() {
		HashMap<Character, counter> hm1 = new HashMap<>();
		for (Character c : hm.keySet()) {
			counter counter = hm.get(c);
			counter newCounter = new counter();
			newCounter.count = counter.count;
			hm1.put(c, newCounter);
		}

		return hm1;
	}

	public String minWindow(String A, String B) {
		if (A == null || B == null || A.length() == 0 || B.length() == 0)
			return "";

		addCharToHashMap(B);
		int count = B.length();
		int start = 0;
		int end = -1;
		int min = Integer.MAX_VALUE;
		String minStringSoFar = "";
		int minStart = 0;
		int minEnd = -1;
		int nextStart = 0;
		while (start < A.length() && end < A.length()) {
			HashMap<Character, counter> lhm = deepCopyHm();

			int decider = 0;
			int flag = 0;
			for (int i = start; i < A.length(); i++) {
				if (lhm.containsKey(A.charAt(i)) && (lhm.get(A.charAt(i)).count > 0) && count > 0) {
					counter c = lhm.get(A.charAt(i));
					c.count -= 1;
					lhm.put(A.charAt(i), c);
					count--;
					end = i;
					if (decider == 1) {
						nextStart = i;
						decider = 2;
						flag = 1;
					}
					if (decider == 0) {
						start = i;
						decider = 1;
					}

				} else if (count == 0) {
					end = i - 1;
					break;
				}
			}
			if (count != 0)
				break;

			if (min > (end - start + 1)) {
				min = end - start + 1;
				minStart = start;
				minEnd = end;
			}
			start++;
			if (start > end)
				break;
			if (flag == 1)
				start = nextStart;
			decider = 0;
			flag=0;
			count = B.length();
		}

		if (minEnd >= minStart) {
			minStringSoFar = A.substring(minStart, minEnd + 1);
		}
		return minStringSoFar;
	}
}
