package Queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindoMax {

	public static void main(String[] args) {
		
		
	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		int max = Integer.MIN_VALUE;

		Deque<Integer> Qi = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		int i = 0;
		for (; i < B; ++i) {

			while (!Qi.isEmpty() && A.get(i) > A.get(Qi.peekLast())) {
				Qi.removeLast();
			}
			
			Qi.addLast(i);
		}
		
		for(;i<A.size();i++){
			//System.out.println(A.get(Qi.peek()));
			result.add(A.get(Qi.peek()));
			while((!Qi.isEmpty()) && Qi.peek()<=i-B){
				Qi.removeFirst();
			}
			
			while (!Qi.isEmpty() && A.get(i) > A.get(Qi.peekLast())) {
				Qi.removeLast();
			}
			
			Qi.addLast(i);
		}
		//System.out.println(A.get(Qi.peek()));
		
		result.add(A.get(Qi.peek()));
		return result;
	}
}
