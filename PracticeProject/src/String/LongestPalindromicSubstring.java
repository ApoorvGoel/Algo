package String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

	static HashMap<String, String> hm = new HashMap<>();

	public static void main(String[] args) {
		HashMap<String, String> hmnew = new HashMap<>();

		String a="abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"+"abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"+"abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp"+"abbanjkkhukjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjkiijjlklk,knkjjnjknknknknknmm,mk,nknknknknnjnknjkbnkklmnknknlknnjkknmkl"
				+ "fjiorjejfioljnsfilejfmoifljkwefojflwe;l/fl'lwpojefmwihfnuriwenwefweuiffkjwienfwlefmeopfjweofjweoifjweofweofmfvmvijriwjijjviwwvwvjvijwrlvmiwevlmvmvlmwvvmwimrvwlv"
				+ "pkcw,wepovcw;;wwc,w;,ceccc;w,cwc;,we,ce;c,eleeeeecl,,,,,,,,,,,,,,,,,,,,,,eweplcpfkepekpfpfkkfpffkfpfkfkfkpfp";
		
		String b="ABAABA";
		//System.out.println(longestPalindrome(b,0,b.length()-1,hmnew));
		//System.out.println(new LongestPalindromicSubstring().ll(a,0,a.length()-1,hmnew));
		
		System.out.println(longestPalindromicSubstrWithoutExtraSpace(a));
	}
	
	
	
	public static String longestPalindromicSubstrWithoutExtraSpace(String s){
		int maxLength=1;
		int start =0;
		int len =s.length();
		int low=0,high=0;
		
		for(int i=1;i<len;i++){
			low= i-1;
			high =i;
			//Even Length Palindrom
			while(low>=0&&high<len&&(s.charAt(low)==s.charAt(high))){
				if(high-low+1>maxLength){
					start=low;
					maxLength=high-low+1;
				}
				--low;
				++high;
			}
			low=i-1;
			high=i+1;

			//Odd Length Palindrom
			while(low>=0&&high<len&&(s.charAt(low)==s.charAt(high))){
				if(high-low+1>maxLength){
					start=low;
					maxLength=high-low+1;
				}
				--low;
				++high;
			}
			
		}
		
		return s.substring(start, maxLength+start);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  String ll(String X, int i, int j, Map<String, String> lookup){
        // base condition
        if (i > j) {
            return "";
        }
 
        // if String X has only one character, it is palindrome
        if (i == j) {
            return ""+X.charAt(i);
        }
 
        // construct a unique map key from dynamic elements of the input
        String key = i + "|" + j;
 
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            /* if last character of the string is same as the first character
            include first and last characters in palindrome and recurse
            for the remaining subString X[i+1, j-1] */
 
            if (X.charAt(i) == X.charAt(j)) {
                lookup.put(key,X.charAt(i)+ ll(X, i + 1, j - 1, lookup) + X.charAt(j));
            } else {
 
            /* if last character of string is different to the first character
 
            1. Remove last char & recurse for the remaining subString X[i, j-1]
            2. Remove first char & recurse for the remaining subString X[i+1, j]
            3. Return maximum of the two values */
            
            	String a=ll(X, i, j - 1, lookup);
            	String b=ll(X, i + 1, j, lookup);
            lookup.put(key, (a.length()>b.length()?a:b));
            }
        }
        // return the sub-problem solution from the map
        return lookup.get(key);
	}
	
	
    public static int longestPalindrome(String A,int i, int j, Map<String,Integer> hm) {
    	
    	if(i>j)
    		return 0;
    	
    	if(i==j)
    		return 1;
    	
    	String key=i+"|"+j;
    	if(!hm.containsKey(key)){
    		if(A.charAt(i)==A.charAt(j)){
    			hm.put(key, longestPalindrome(A,i+1,j-1,hm));
    		}
    		else{
    			hm.put(key,Integer.max(longestPalindrome(A,i,j-1,hm),longestPalindrome(A,i+1,j,hm)));
    		}
    	}
    	
    	return 0;
    }
	
	public static String longestPalindromeUsingHashMap(String A) {
		if(A==null|| A.trim()=="")
			return A;
		
		if (checkPalindrome(A))
			return A;

		String a = A.substring(1, A.length());
		if (hm.get(a) == null) {
			a = longestPalindromeUsingHashMap(A.substring(1, A.length()));
			hm.put(A.substring(1, A.length()), a);
		} else
			a = hm.get(a);
		String b = A.substring(0, A.length() - 1);
		if (hm.get(b) == null) {
			b = longestPalindromeUsingHashMap(A.substring(0, A.length() - 1));
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
