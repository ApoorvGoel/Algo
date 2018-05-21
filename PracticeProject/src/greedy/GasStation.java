package greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GasStation {

	public static void main(String[] args) {
		
		ArrayList<Integer> gas= new ArrayList<Integer>();
		ArrayList<Integer> cost= new ArrayList<Integer>();
		/*	gas.add(1);
		gas.add(2);
		gas.add(3);
		gas.add(4);
		gas.add(5);
		gas.add(6);
		
		cost.add(6);
		cost.add(5);
		cost.add(4);
		cost.add(3);
		cost.add(2);
		cost.add(1);*/
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= B.get(i)) {
				queue.offer(i);
			}
		}
		while (queue.peek() != null) {
			int i = queue.poll();
			int gas = A.get(i) - B.get(i);
			int j;
			for (j = (i + 1)%A.size(); j != i; j = (j + 1) % A.size()) {
				gas = gas + A.get(j) - B.get(j);
				if (gas < 0)
					break;
			}
			if (i == j)
				return i;
		}
		return -1;
	}
}