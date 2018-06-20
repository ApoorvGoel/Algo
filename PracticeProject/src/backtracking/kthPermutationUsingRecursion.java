package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class kthPermutationUsingRecursion {

	
	//Correct Sollution
	public static void main(String[] args) {
		/*
		 * ArrayList<Integer> al = new ArrayList<>(); al.add(1); al.add(2);
		 * String res =al.toString();
		 * System.out.println(res.substring(1,res.length()-1));
		 */
		kthPermutationUsingRecursion knP = new kthPermutationUsingRecursion();

		// System.out.println(knP.startingElement(15,knP.factorial(3)));
		//System.out.println(knP.getPermutation(11, 3628802));
		System.out.println(knP.getPermutation(3,4));
	}

	public long factorial(int A) {
		 if(A>12)
		        return Long.MAX_VALUE;
		long fact = 1;
		while (A >= 1) {
			fact = fact * A;
			A = A - 1;
		}
		return fact;
	}

	public long startingElement(long k, long fact) {
		if (k % fact == 0)
			return k / fact;
		return (k / fact) + 1;
	}

	public long getB(long k, long fact) {
		if (k % fact == 0)
			return fact;
		return k % fact;
	}

	public String getPermutation(LinkedList<Long> ll, long k) {
		if (k == 1)
			return convertListToString(ll);
		long fact = factorial(ll.size() - 1);
		long startIndex = startingElement(k, fact);
		long nextK = getB(k, fact);
		String result=""+	ll.remove(((int)startIndex)-1);
		//ll = removeIndex(ll, startIndex - 1);
		return result + getPermutation(ll, nextK);
	}

	public String removeIndex(String s, int i) {
		StringBuilder sb = new StringBuilder(s);
		sb.deleteCharAt(i);
		return sb.toString();
	}
	public String convertListToString(List<Long> ll){
		StringBuilder sb = new StringBuilder();
		for (Long long1 : ll) {
			sb.append(long1);
		}
		return sb.toString();
	}
	
	public String getPermutation(int A, int B) {
		LinkedList<Long> ll = new LinkedList<>();
		for(int i=1;i<=A;i++){
				ll.add((long)i);
		}
		if (B == 1) {
			return convertListToString(ll);
		}
		return getPermutation(ll, B);
	}

}
