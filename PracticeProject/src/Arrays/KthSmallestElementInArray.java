package Arrays;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInArray {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		A.add(2);
		A.add(1);
		A.add(4);
		A.add(3);
		A.add(2);
		System.out.println(new KthSmallestElementInArray().kthsmallest(A, 3));
	}

	
	// By Swapping Array Elements
	public int kthsmallest(final List<Integer> A, int B) {
		int min =Integer.MAX_VALUE;
		int prevMin=-1;
		for(int i=0;i<B;i++){
			min=A.get(i);
			for(int j=0;j<A.size();j++){
				if(A.get(j)>prevMin&&A.get(j)<min)
				{ 
					
					min =A.get(j);
				}
					
			}
			prevMin=min;;
		}
		return min;
	}
	
	void swap(List<Integer> A, int i, int j){
		int temp=A.get(i);
		A.set(i, A.get(j));
		A.set(j,temp);
	}
}
