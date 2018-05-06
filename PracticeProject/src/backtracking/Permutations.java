package backtracking;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		System.out.println(new Permutations().permuteIndex(res, A, 0, 3));
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		
		
		return null;
	}
	
	public void swap(ArrayList<Integer> A,int i,int j){
		int temp =A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
	public ArrayList<ArrayList<Integer>> permuteIndex(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> A,int i,int j) {
		
		if(i==j)
		{	
			ArrayList<Integer> r = new ArrayList<>(A);
			res.add(r);
			return res;
		}
		
		for(int k =i;k<=j;k++){
			System.out.println(A);
			swap(A,k,i);
			permuteIndex(res, A, i+1, j);
			swap(A,k,i);
		}
		return res;
	}
}
