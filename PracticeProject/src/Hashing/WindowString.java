package Hashing;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class WindowString {

	public static void main(String[] args) {
		System.out.println(new WindowString().minWindow("AAAAAA", "AA"));
	}

	public void addCharToHashMap(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (hm.containsKey(s.charAt(i))){
				hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);}
			else
				hm.put(s.charAt(i), 1);
		}
	}

	HashMap<Character, Integer> hm = new HashMap<>();
	TreeMap<Integer, String> resultMap = new TreeMap<>();

	public String minWindow(String A, String B) {
		if (A == null || B == null || A.length() == 0 || B.length() == 0)
			return "";

		addCharToHashMap(B);
		int count = B.length();
		int start = 0;
		int end = -1;
		while (start < A.length() && end < A.length()) {
			// System.out.println(start);
			// System.out.println(end);
			for (int i = start; i < A.length(); i++) {
				if (hm.containsKey(A.charAt(i)) && (hm.get(A.charAt(i)) > 0) && count > 0) {
					hm.put(A.charAt(i), hm.get(A.charAt(i)) - 1);
					count--;
					end = i;
				} else if (count == 0) {
					end = i - 1;
					break;
				}
			}
			if (count != 0)
				break;

			for (int i = start; i <= end; i++) {
				if (hm.containsKey(A.charAt(i))) {
					start = i;
					break;
				}
			}
			// System.out.println(start);
			// System.out.println(end);
			// System.out.println( A.substring(start, end+1));
			if (!resultMap.containsKey(end - start + 1))
				resultMap.put(end - start + 1, A.substring(start, end + 1));
			start++;

			if (start > end)
				break;
			while (end > start) {
				if (hm.containsKey(A.charAt(start))) {
					break;
				} else {
					start++;
				}
			}
			hm.clear();
			addCharToHashMap(B);
			count = B.length();
		}

		Set<Integer> keySet = resultMap.keySet();
		for (Integer integer : keySet) {
			return resultMap.get(integer);
		}

		return "";
	}
}
