package TwoPointers;

import java.util.ArrayList;

import Spiral.MainEntry;

public class RemoveDuplicates {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(4);
		// System.out.println(removeDuplicates(a));
		//System.out.println(removeDuplicatesEfficiently(a));
		
		a.clear();
		
		/*a.add(500);
		a.add(500);
		a.add(50);
		a.add(50);
		a.add(250);
		a.add(250);
		
		System.out.println(Integer.valueOf(a.get(0))!=Integer.valueOf(a.get(1)));
		System.out.println(500!=500);
		int a0=Integer.valueOf(a.get(0));
		int a1=Integer.valueOf(a.get(1));
		System.out.println(a0!=a1);
		System.out.println(Integer.valueOf(a.get(2))!=Integer.valueOf(a.get(3)));
		System.out.println(Integer.valueOf(a.get(4))!=Integer.valueOf(a.get(5)));*/
		
		a.add(500);
		a.add(500);
		a.add(500);
		
		//System.out.println(removeDuplicatesEfficiently(a));
	
		a.clear();
		a.add(500);
		a.add(500);
		a.add(500);
		System.out.println(removeDuplicatesCorrectApproach(a));
	}
	public static int removeDuplicatesCorrectApproach(ArrayList<Integer> a) {
		int j = 0;
		for (int i = 0; i < a.size() - 1; i++) {
                int curr=a.get(i);
                int next=a.get(i + 1);
			if (curr != next) {
				a.set(j++, curr);

			}
		}
		a.set(j++, a.get(a.size() - 1));

		for (int i = a.size() - 1; i >= j; i--)
			a.remove(i);
		return a.size();
	}
	public static int removeDuplicatesEfficiently(ArrayList<Integer> a) {
		int j = 0;
		for (int i = 0; i < a.size() - 1; i++) {

			if (a.get(i) != a.get(i + 1)) {
				a.set(j++, a.get(i));
			}
		}
		a.set(j++, a.get(a.size() - 1));
		for (int i = a.size() - 1; i >= j; i--)
			a.remove(i);
		return a.size();
	}

	public static int removeDuplicates(ArrayList<Integer> a) {
		int prev;
		int next;
		for (int i = 0; i < a.size() - 1; i++) {
			prev = a.get(i);
			next = a.get(i + 1);
			while (prev == next) {
				a.remove(i);

				if (i < a.size() - 1) {
					prev = a.get(i);
					next = a.get(i + 1);
				} else {
					break;
				}
			}
		}

		return a.size();
	}
}
