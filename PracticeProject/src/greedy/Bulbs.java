package greedy;

import java.util.ArrayList;

public class Bulbs {

	public static void main(String[] args) {

	}

	public int bulbs(ArrayList<Integer> A) {
		int position = 0;
		int counter = 0;
		while (position != A.size()) {
			for (int i = position; i < A.size(); i++) {
				if (A.get(i) == 0) {
					position = i;
					break;
				}
			}
			if(position<A.size())
				counter++;
			for (int j = position; j < A.size(); j++) {
				A.set(j, 1 - A.get(j));
			}

		}
		return counter;
	}
}
