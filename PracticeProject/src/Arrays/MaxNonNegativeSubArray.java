package Arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
	/*	a.add(1);
		a.add(2);
		a.add(5);
		a.add(-7);
		a.add(2);
		a.add(3);
		A : [ 1967513926, 1540383426, -1303455736, -521595368 ]
		*/
	/*	a.add(1967513926);
		a.add(1540383426);
		a.add(-1303455736);
		a.add(-521595368);
		A : [ 756898537, -1973594324, -2038664370, -184803526, 1424268980 ]
		*/
		a.add(756898537);
		a.add( -1973594324);
		a.add(-2038664370);
		a.add(1424268980);
		System.out.println(maxset(a));
	}
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    long sum=-1;
	    long currentSum=0;
	    ArrayList<Integer> result= new ArrayList<>();
	    ArrayList<Integer> CurrentResult= new ArrayList<>();
		for (int integer : a) {
			
			if(integer>=0){
				CurrentResult.add(integer);
				currentSum=currentSum+integer;
			}else{
				if(sum<currentSum){
					sum=currentSum;
					result.clear();
					result.addAll(CurrentResult);
				}else if(sum==currentSum){
					if(result.size()<CurrentResult.size()){
						result.clear();
						result.addAll(CurrentResult);
					}
				}
				currentSum=0;
				CurrentResult.clear();
			}
		}
		if(sum<currentSum){
			sum=currentSum;
			result.clear();
			result.addAll(CurrentResult);
		}else if(sum==currentSum){
			if(result.size()<CurrentResult.size()){
				result.clear();
				result.addAll(CurrentResult);
			}
		}
	    
	return result;    
	}
}
