package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Spiral.MainEntry;

public class PainterPartitionProblem {

	public static void main(String[] args) {
		int arr[] = {9,  6, 7, 8, 1, 2, 3, 4, 5 };

		// Calculate size of array.
		int n = arr.length;
		int k = 1;
		ArrayList<Integer> C = new ArrayList<Integer>();
		int TimeTakenByPainter=1000000;
/*		C.add(9);
		C.add(6);
		C.add(7);
		C.add(8);
		C.add(1);
		C.add(2);
		C.add(3);
		C.add(4);
		C.add(5);*/
		
		C.add(1000000);
		C.add(1000000);
		System.out.println(new PainterPartitionProblem().paint(k, TimeTakenByPainter, C));
	}

	public int paint(int noOfPainter, int TimeTakenByPainter, ArrayList<Integer> C) {
		long maxUnitsRequired=getSum(C);
		long minUnitsRequired=getMax(C);
		
		
		while(minUnitsRequired<maxUnitsRequired){
			long mid = (minUnitsRequired+maxUnitsRequired)/2;
			int painterRequiredForMid=partition(C,mid,noOfPainter);
			if(painterRequiredForMid<=noOfPainter)
			{
				maxUnitsRequired=mid;
			}else{
				minUnitsRequired=mid+1;
			}
		}
			
		return (int)((minUnitsRequired*TimeTakenByPainter)%10000003);
	}
	/*
	 * 		long r1=minUnitsRequired%10000003;
		long r2 =TimeTakenByPainter%10000003;
		long r3= r1*r2;
		
		return (int)(r3%10000003);
	 */
	
	private int partition(ArrayList<Integer> c, long cost,int noOfPainter) {
		long sum=0;
		int painterRequiredForMid=1;
		for(int i=0;i<c.size();i++){
			sum = sum+c.get(i);
			
			if(sum>cost){
				sum =c.get(i);
				painterRequiredForMid++;
			}
			
		}
		return painterRequiredForMid;
	}

	public long getSum(ArrayList<Integer> C){
		long sum=0;
		for (Integer integer : C) {
			sum =sum + integer;
		}
		return sum;
	}
	
	public long getMax(ArrayList<Integer> C){
		return Collections.max(C);
	}
	
}
