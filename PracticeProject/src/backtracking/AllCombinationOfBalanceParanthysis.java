package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class AllCombinationOfBalanceParanthysis {

	public static void main(String[] args) {
		
		String s="{{";
		 s=s.substring(0,s.length()-1)+")";
		 System.out.println(s);
		ArrayList<String> al=new ArrayList<>();
		new AllCombinationOfBalanceParanthysis().generateParanthesis(al,new char[6],0,3,0,0);
		//Collections.reverse(al);
		System.out.println(al);
	}
	public ArrayList<String> generateParenthesis(int A) {
    
		return null;
	}
	
	 void generateParanthesis(ArrayList<String> res,char[] s,int pos,int A,int openCount,int closeCount){
		 if(closeCount==A){
			 String snew = new String(s);
			 res.add(snew);
			 return;
		 }
		
		 if(openCount<A){
			 s[pos]='(';
			 generateParanthesis(res, s,pos+1, A, openCount+1, closeCount);
		}
		 if(closeCount<openCount){
				s[pos]=')';
				 generateParanthesis(res, s,pos+1, A, openCount, closeCount+1);
		 }
	 }
}
