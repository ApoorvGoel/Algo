package Arrays;

import java.util.Collections;
import java.util.List;

public class KthSmallestElementInArrayWithoutSwapI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Without swapping the array elements
	 public int kthsmallest(final List<Integer> A, int B) {
			int min =Integer.MAX_VALUE;
			int prevMin=Integer.MIN_VALUE;
			int count=0;
			
			
			int size=A.size();
			int data=0;
			for(int i=0;i<B;){
				min =Integer.MAX_VALUE;
				for(int j=0;j<size;j++){
				    data=A.get(j);
					if((data>prevMin)&&(data<min))
					{ 
						min =data;
						count=1;
					}else if((data>prevMin)&&(data==min)){
					    count++;
					}
				}
				prevMin=min;
				i=i+count;    
			}
			return min;
		}
		
}
