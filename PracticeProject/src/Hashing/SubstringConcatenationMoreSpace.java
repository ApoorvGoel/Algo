package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SubstringConcatenationMoreSpace {

	public static void main(String[] args) {

	}
	//Answer is correct, but will give heap memory exception in case of following input:
	//A : "acaaacbcbccbaabaccabcbbcaaccbbbbcbabaacbbcbccababb"
	//B : [ "cabccbbbc", "abbccabbc", "bbbcbbbaa", "acbaabcab", "ccacabccb", "bbacaabca", "acacbaacb", "aabbcccab", "ccccbbcaa", "baaccaabc" ]
	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
		ArrayList<String> bl = new ArrayList<>(B);
		HashSet<String> hs = new HashSet<>();
		permute(hs, bl, 0, bl.size() - 1);
		int len = 0;
		for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			len = string.length();
			break;
		}
		ArrayList<Integer> result = new ArrayList<>();
		//System.out.println(len);
		for (int i = 0; i < A.length() && ((i+len)<=A.length()); i++) {
			String temp = A.substring(i, i+len);
			if (hs.contains(temp)) {
				result.add(i);
			}
		}

		return result;
	}

	String convertListToString(List<String> A) {
		StringBuilder sb = new StringBuilder();
		for (String string : A) {
			sb.append(string);
		}
		return sb.toString();
	}

	void permute(HashSet<String> hs, List<String> A, int i, int j) {
		if (i == j) {
			hs.add(convertListToString(A));
			return;
		}

		for (int k = i; k <= j; k++) {
			swap(A, k, i);
			permute(hs, A, i+1, j);
			swap(A, k, i);
		}
	}

	void swap(List<String> A, int i, int j) {
		String temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	} 
}
