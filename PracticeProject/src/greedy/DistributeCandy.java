package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DistributeCandy {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(-5);
		A.add(-9);
		A.add(-8);
		A.add(0);
		A.add(1);
		A.add(0);
		A.add(-5);
		A.add(2);
		A.add(3);
		A.add(2);
		A.add(4);
		System.out.println(new DistributeCandy().candy(A));
	}

	public int candy(ArrayList<Integer> A) {
		PriorityQueue<ChildNode> pq = new PriorityQueue<ChildNode>(new RatingComparator());
		int[] candyArray = new int[A.size()];

		for (int i = 0; i < A.size(); i++) {
			pq.offer(new ChildNode(i, A.get(i)));
		}
		while (pq.peek() != null) {
			ChildNode node = pq.poll();
			int candy = 1;
			if ((node.index - 1) > -1 && (A.get(node.index) > A.get(node.index - 1))) {
				candy = (candy > candyArray[node.index - 1]) ? candy : candyArray[node.index - 1]+1;
			}
			if (((node.index + 1) < A.size()) && (A.get(node.index) > A.get(node.index + 1))) {
				candy = (candy > candyArray[node.index + 1]) ? candy : candyArray[node.index + 1]+1;
			}

			candyArray[node.index] = candy;
		}
		int result = 0;
		for (int i=0;i<candyArray.length;i++) {
			result += candyArray[i];
		}
		return result;
	}
}

class ChildNode {
	int index;
	int rating;

	public ChildNode(int index, int rating) {
		super();
		this.index = index;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ChildNode [index=" + index + ", rating=" + rating + "]";
	}

}

class RatingComparator implements Comparator<ChildNode> {

	@Override
	public int compare(ChildNode o1, ChildNode o2) {
		return Integer.compare(o1.rating, o2.rating);
	}

}