package String;

import java.util.HashMap;

public class LongestPalindromicSubstring {

	static HashMap<String, String> hm = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"+"abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"+"abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"+"abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"));
	}

	public static String longestPalindrome(String A) {
		if(A==null|| A.trim()=="")
			return A;
		
		if (checkPalindrome(A))
			return A;

		String a = A.substring(1, A.length());
		if (hm.get(a) == null) {
			a = longestPalindrome(A.substring(1, A.length()));
			hm.put(A.substring(1, A.length()), a);
		} else
			a = hm.get(a);
		String b = A.substring(0, A.length() - 1);
		if (hm.get(b) == null) {
			b = longestPalindrome(A.substring(0, A.length() - 1));
			hm.put(A.substring(0, A.length() - 1), b);
		} else
			b = hm.get(b);

		return (a.length() <= b.length()) ? b : a;
	}

	public static boolean checkPalindrome(String s) {
		int n = s.length() - 1;
		if (s.length() % 2 == 0) {
			for (int i = 0; i <= n / 2; i++) {
				if (s.charAt(i) != s.charAt(n - i))
					return false;
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) != s.charAt(n - i))
					return false;
			}
		}

		return true;
	}
}
