package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnPlaceToInsert {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		al.add(3);
		al.add(5);
		al.add(7);
		al.add(10);
		System.out.println(binarySearch(al, 4, 0, 4));
		System.out.println(al.toArray());
		System.out.println(Arrays.binarySearch(al.toArray(), 4));
	}

	static int binarySearch(ArrayList<Integer> al, int element, int i, int j) {
		int temp = 0;
		if (i > j) {
			/*temp = al.get(i);
			if (temp == element) {
				return i;
			}*/
			return -(i+1);
		}	
			int mid=(i+j)>>>1;
			temp=al.get(mid);
			
			if(temp==element)
				return mid;
			if(temp>element)
				return(binarySearch(al, element, i, mid-1));
			else
				return(binarySearch(al, element, mid+1, j));
	}

}
