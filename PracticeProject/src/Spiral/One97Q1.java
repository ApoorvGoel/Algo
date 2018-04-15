package Spiral;

import java.util.NavigableSet;
import java.util.TreeSet;

public class One97Q1 {

	public static void main(String[] args) {
		
		
		//Collection<Integer> collection = new HashSet<Integer>();
		//Set<Integer> collection = new HashSet<Integer>();
		//HashSet<Integer> collection = new LinkedHashSet<Integer>();
		//Set<Integer> collection = new LinkedHashSet<Integer>();
		//Collection<Integer> collection = new TreeSet<Integer>();
		NavigableSet<Integer> collection = new TreeSet<Integer>();
		collection.add(1); collection.add(9); collection.add(1);
         System.out.println(collection);

	}
	

}

