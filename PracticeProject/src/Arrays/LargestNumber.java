package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Integer> intAl = new ArrayList<>();
		intAl.add(657);
		intAl.add(4);
		intAl.add(8);
		intAl.add(888);
		intAl.add(65);
		intAl.add(0000);
		intAl.add(999);
		intAl.add(999);
		intAl.add(681);
		intAl.add(6);
		intAl.add(648);
		intAl.add(644);
		intAl.add(116);
		intAl.add(1);
		
		Collections.sort(intAl, new IntegerComparator());
		System.out.println(intAl);
		System.out.println(noOfBits(0));
		System.out.println("rr"+intAl.toString());
		
		
		String result="";
		for (Integer integer : intAl) {
			result=result+integer;
		}
		System.out.println(result);
		
		
	}
	 public String largestNumber(final List<Integer> A) {
	        Collections.sort(A, new IntegerComparator());
	        StringBuilder result=new StringBuilder();
	        int temp=A.get(0);
	        if(temp==0)
	            return "0";
			for (Integer integer : A) {
				result.append(integer);
			}
			return result.toString();
	    }
	static int noOfBits(int digit) {
		String sdigit = digit + "";
		return sdigit.length();
	}
}

class IntegerComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2){
		StringBuilder sa=new StringBuilder();
		sa.append(o1);
		sa.append(o2);
		StringBuilder sb=new StringBuilder();
		sb.append(o2);
		sb.append(o1);
		long sai=Long.parseLong(sa.toString());
		long sbi=Long.parseLong(sb.toString());
		if(sai>sbi){
			return -1;
		}else if(sai<sbi){
			return 1;
		}else
			return 0;
	}
	
	
	
	
	public int comparedd(Object o1, Object o2) {
		int a = (int) o1;
		int b = (int) o2;
		String sa = a + "";
		String sb = b + "";
		int i = 0;
		for (i = 0; i < sa.length() && i < sb.length();) {
			if (sa.charAt(i) > sb.charAt(i)) {
				return -1;
			} else if (sa.charAt(i) == sb.charAt(i)) {
				i++;
				continue;
			} else
				return 1;
		}
		if (sa.length() == sb.length())
			return 0;

		if (sa.length() > sb.length()) {
			
				while(i<sa.length()&&sa.charAt(i)==sb.charAt(0)){
					i++;
				}
				if(i==sa.length()){
					return 1;
				}
				if (sa.charAt(i) > sb.charAt(0))
					return -1;
			return 1;
		} else {
			while(i<sb.length()&&sb.charAt(i)==sa.charAt(0)){
				i++;
			}
				if(i==sb.length()){
				return -1;
			}
			if (sa.charAt(0) < sb.charAt(i)) {
					return 1;
				}
			
			}
			return -1;
		}

	}


