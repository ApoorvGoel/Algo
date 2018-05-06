package Math;

import java.util.HashMap;

public class ExcellColloumnTitle {

	static HashMap<Integer, String> hm = new HashMap<>();

	public static void main(String[] args) {
		hm.put(0, "");
		hm.put(1, "A");
		hm.put(2, "B");
		hm.put(3, "C");
		hm.put(4, "D");
		hm.put(5, "E");
		hm.put(6, "F");
		hm.put(7, "G");
		hm.put(8, "H");
		hm.put(9, "I");
		hm.put(10, "J");
		hm.put(11, "K");
		hm.put(12, "L");
		hm.put(13, "M");
		hm.put(14, "N");
		hm.put(15, "O");
		hm.put(16, "P");
		hm.put(17, "Q");
		hm.put(18, "R");
		hm.put(19, "S");
		hm.put(20, "T");
		hm.put(21, "U");
		hm.put(22, "V");
		hm.put(23, "W");
		hm.put(24, "X");
		hm.put(25, "Y");
		hm.put(26, "Z");
		System.out.println(convertToTitle(943566));
	}

	public static String convertToTitle(int A) {
		if(A/26==0)
			return hm.get(A);
		if(A%26==0)
			return convertToTitle((A-1)/26)+hm.get(26);
		return convertToTitle(A/26)+hm.get(A%26);
	}

	void colloumnTitle() {

	}

}
