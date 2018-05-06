package backtracking;

import java.util.ArrayList;

public class kthPermutationWrongSolution {

	public static void main(String[] args) {
	/*	ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		String res =al.toString();
		System.out.println(res.substring(1,res.length()-1));*/
		kthPermutationWrongSolution knP=new kthPermutationWrongSolution();
		
	//	System.out.println(knP.startingElement(15,knP.factorial(3)));
		System.out.println(knP.getPermutation(4,5));
	}
	
	public int permute(ArrayList<Integer> al,int i, int j,int startingindex, int k){
		
		
		return 0;
	}
	
	public int factorial(int A){
	    int fact=1;
	    while(A>=1){
	        fact=fact*A;
	        A=A-1;
	    }
	    return fact;
	 }
	 
	 public int startingElement(int k,int fact){
		 if(k%fact==0)
			 return k/fact;
	     return (k/fact)+1;
	 }
	 public int getB(int k,int fact){
		 if(k%fact==0)
			 return fact;
	     return k%fact;
	 }
	public String getPermutation(int A, int B) {
		ArrayList<Integer> al = new ArrayList<>();
		if(B==1){
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=A;i++){
				sb.append(i);
			}
			return sb.toString();
		}
		
		
		int fact=factorial(A-1);
		int startElement=startingElement(B,fact);
		
		for(int i=1;i<=A;i++){
			if(!(i==startElement))
			al.add(i);
		}
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		int c=getB(B,fact);
		System.out.println(c);
		permuteIndex(res,al,0,al.size()-1,c);
		System.out.println(res);
		/*if(B<=fact)
			al=res.get(B-1);*/
		
	/*	int ind=B-((startElement*fact)-1);
		if(ind<res.size()&& ind>=0)
		al=res.get(ind);
		else*/
		al=res.get(res.size()-1);
		return startElement+convertListToString(al);
		//return startElement+"";
	}
	
	public String convertListToString(ArrayList<Integer> al){
		StringBuilder sb = new StringBuilder();
		for (Integer integer : al) {
			sb.append(integer);
		}
		return sb.toString();
	}
	
	
	public void swap(ArrayList<Integer> A,int i,int j){
		int temp =A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
	
	public ArrayList<ArrayList<Integer>> permuteIndex(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> A,int i,int j,int B) {
		
		if(i==j)
		{	
			ArrayList<Integer> r = new ArrayList<>(A);
			res.add(r);
			return res;
		}
		if(B==res.size())
			return res;
		
		for(int k =i;k<=j;k++){
			if(B==res.size())
				return res;
			
			swap(A,k,i);
			permuteIndex(res, A, i+1, j,B);
			swap(A,k,i);
		}
		return res;
	}
}
