package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationWithUniqueElementsInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * * The below code is correct if values are distinct:
	 */
	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
		if (B.size() == 0 || A.length() == 0)
			return new ArrayList<Integer>();

		HashMap<String, Boolean> hm = new HashMap<>();
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
					if (hm.containsKey(temp) && hm.get(temp) != true)
						hm.put(temp, true);
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

	public void resetHashMap(HashMap<String, Boolean> hm, final List<String> B) {
		for (String string : B) {
			hm.put(string, false);
		}
	}

	public boolean areAllElementsUsed(HashMap<String, Boolean> hm, final List<String> B) {
		for (String string : B) {
			if (hm.get(string) == false)
				return false;
		}
		return true;
	}
}
