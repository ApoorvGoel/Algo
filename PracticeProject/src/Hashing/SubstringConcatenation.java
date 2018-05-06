package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SubstringConcatenation {

	public static void main(String[] args) {
		/*
		 * String A="barfoothefoobarman"; List<String> B = new ArrayList<>();
		 * B.add("foo"); B.add("bar"); String A=
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		 * List<String> B = new ArrayList<>(); B.add("aaa"); B.add("aaa");
		 * B.add("aaa"); B.add("aaa"); B.add("aaa");
		 * 
		 * //B.add("aaa"); //String a=
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		 * System.out.println(A.length()); System.out.println(new
		 * SubstringConcatenation().findSubstring(A,B));
		 */

		HashMap<Integer, Boolean> hm = new HashMap<>();
		hm.put(1, true);
		hm.put(2, true);
		Set<Integer> keyset = hm.keySet();

	}

	//Correct Solution
	public void resetHashMap(HashMap<String, Integer> hm, final List<String> B) {
		hm.clear();
		for (String string : B) {
			if (hm.containsKey(string)) {
				hm.put(string, hm.get(string)+1);
			}else
				hm.put(string, 1);
		}
	}

	public boolean areAllElementsUsed(HashMap<String, Integer> hm, final List<String> B) {
		for (String string : hm.keySet()) {
			if(hm.get(string)!=0)
				return false;
		}
		return true;
	}

	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
		if (B.size() == 0 || A.length() == 0)
			return new ArrayList<Integer>();

		HashMap<String, Integer> hm = new HashMap<>();
		resetHashMap(hm, B);
		ArrayList<Integer> result = new ArrayList<>();
		int len = B.size();
		int tLen = B.get(0).length();
		len = len * tLen;
		for (int i = 0; i < A.length(); i++) {
			if ((A.length() - i) >= len) {
				int k;
				for (k = i; k < i + len;) {
					String temp = A.substring(k, k + tLen);
					if (hm.containsKey(temp) && hm.get(temp) != 0)
						hm.put(temp, hm.get(temp)-1);
					else
						break;
					k = k + tLen;
				}
				if (k == (i + len)) {
					if (areAllElementsUsed(hm, B)) {
						result.add(i);
					}
				}
				resetHashMap(hm, B);
			}
		}

		return result;
	}
}
