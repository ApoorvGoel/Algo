package greedy;

import java.util.ArrayList;

public class BulbsOptimized {

	public static void main(String[] args) {

	}
	public int bulbs(ArrayList<Integer> A) {
		int counter = 0;
			for (int i = 0; i < A.size(); i++) {
				if(A.get(i)==0)
				if ((i+1)<A.size() && A.get(i+1)==1) {
					counter++;
				}
			}
			counter=counter*2;
			if(A.get(A.size()-1)==0)
			{
				counter+=1;
			}
		return counter;
	}
}
