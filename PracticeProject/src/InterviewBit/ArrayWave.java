package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 
 * Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]


 */
public class ArrayWave {
	
	
	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(-57);
		al.add(5);
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(-27);
		System.out.println(solve(al));
	}
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A){
		
		Collections.sort(A);
		
		for(int i=0;i<A.size()-1;i++){
			int a=A.get(i);
			int b=A.get(i+1);
			A.set(i+1,a);
			A.set(i, b);
			i++;
		}
		
		return A;
	}

}
