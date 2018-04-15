package TwoPointers;

import java.util.ArrayList;

public class ArrayMerge {

	public class Solution {
		public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
			ArrayList<Integer> result = new ArrayList<>();
			int i = 0;
			int j = 0;
			while (i < a.size() && j < b.size()) {
				if (a.get(i) <= b.get(j)) {
					result.add(a.get(i));
					i++;
				} else {
					result.add(b.get(j));
					j++;
				}
			}
			while (i < a.size()){
				result.add(a.get(i));
				i++;
			}
			while(j<b.size()){
				result.add(b.get(j));
				j++;
			}
			
			a.clear();
			a.addAll(result);
		}
	}

}
