package Spiral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class textCollection {
public static void main(String[] args) {
	Map<String,List<String>>  unsubPackGroup=new HashMap<String, List<String>>();
			List<String> a = new ArrayList<String>() ;
			a.add("a");
			a.add("b");
			a.add("c");
			a=	Collections.unmodifiableList(a);

			unsubPackGroup.put("Apoorv",a);
			System.out.println(unsubPackGroup);
			unsubPackGroup=	Collections.unmodifiableMap(unsubPackGroup);
			Object test=unsubPackGroup;
			
			Map<String,List<String>> mmTest=(Map<String, List<String>>) test;
			mmTest.get("Apoorv").remove(0);
			
			System.out.println(mmTest);
			unsubPackGroup.get("Apoorv").remove(0);
			
			System.out.println(unsubPackGroup);
			
}
}
