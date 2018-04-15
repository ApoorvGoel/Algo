package practice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQPractice {

	public static void main(String[] args) {
		ArrayList<Integer> num= new  ArrayList<Integer>();
		int k=5;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);	
		for (Integer integer : num) {
			
			q.add(integer);
			if(q.size()>k){
				q.poll();
			}
		}
		System.out.println(q.peek());
	}

}
