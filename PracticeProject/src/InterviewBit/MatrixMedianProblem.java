package InterviewBit;

import java.util.Collections;
import java.util.List;

public class MatrixMedianProblem {

	public static void main(String[] args) {

	}

	public Integer MatrixMedian(List<List> matrix) {

		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		for (List list : matrix) {
			if(min>(Integer)list.get(0))
				min=(Integer)list.get(0);
		}
		
		for (List list : matrix) {
			if(max<(Integer)list.get(list.size()-1))
				max=(Integer)list.get(list.size()-1);
		}

		int mid=(min+max)/2;
		int index=0;
		
		for(int i=0;i<matrix.size();i++){
			 index=Collections.binarySearch(matrix.get(i),mid);
			if(index>0){
				break;
			}
		}
		
		
		return 1;
	}
}
