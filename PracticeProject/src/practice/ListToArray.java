package practice;

import java.util.ArrayList;
import java.util.List;

public class ListToArray {

	public static void main(String[] args) {
		List<String> a= new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		String [] b= a.toArray(new String[a.size()]);
		for (String string : b) {
			System.out.println(string);
			
		}
		
	}
}
