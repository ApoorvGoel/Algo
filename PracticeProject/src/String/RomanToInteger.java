package String;

import java.util.HashMap;

public class RomanToInteger {
	static HashMap<Character,Integer> hm = new HashMap<>(); 
	public static void main(String[] args) {
		System.out.println(romanToIntNew("IIIV"));
	}

	public static int romanToIntNew(String A) {
		hm.put('I',1);
		hm.put('V',5);
		hm.put('X',10);
		hm.put('L',50);
		hm.put('C',100);
		hm.put('D',500);
		hm.put('M',1000);
		
		
		int currSum=hm.get(A.charAt(A.length()-1));
		int prev=hm.get(A.charAt(A.length()-1));
		int cur=0;
		
		for(int i=A.length()-2;i>=0;i--){
			cur=hm.get(A.charAt(i));
			if(cur<prev){
				currSum=currSum-cur;
			}else{
				currSum=currSum+cur;
			}
			prev=cur;
		}
		return currSum;
	}
	
	
	
	public static int romanToInt(String A) {
		hm.put('I',1);
		hm.put('V',5);
		hm.put('X',10);
		hm.put('L',50);
		hm.put('C',100);
		hm.put('D',500);
		hm.put('M',1000);
		
		int max=0;
		int k=0;
		int sum=0;
		for(int i=0;i<A.length();i++){
			if(hm.get(A.charAt(i))>=max){
				max=hm.get(A.charAt(i));
				k=i;
			}
		}
		sum= sum +hm.get(A.charAt(k));
		for(int i=0;i<k;i++){
			if(A.charAt(i)==hm.get(A.charAt(k))){
				sum= sum +hm.get(A.charAt(k));
			}else{
				sum= sum -hm.get(A.charAt(i));
			}
		}
		for(int i=k+1;i<A.length();i++){
				sum= sum +hm.get(A.charAt(i));
		}
		
		
		return sum;

	}
}
