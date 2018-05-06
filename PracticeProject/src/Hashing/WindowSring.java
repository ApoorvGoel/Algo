package Hashing;

import java.util.HashMap;

public class WindowSring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void addCharToHashMap(String s){
		for(int i=0;i<s.length();i++){
			if(hm.containsKey(s.charAt(i)))
				hm.put(s.charAt(i), hm.get(s.charAt(i)+1));
			else
				hm.put(s.charAt(i),1);
		}
	}
	HashMap<Character,Integer> hm = new HashMap<>();
	 public String minWindow(String A, String B) {
		 addCharToHashMap(B);
		 int count=0;
		 int min=Integer.MAX_VALUE;
		 int start=-1;
		 for(int i=0;i<A.length();i++){
			 if(hm.containsKey(A.charAt(i))){
				 count++;
				 start=i;
			 }
		 }
		 
	 return null;   
	 }
}
