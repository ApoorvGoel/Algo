package practice;

public class TestJava {

	public static void main(String[] args) {

		int i=0;
		float f =45.0f;
		double d =49.0;
		long l =0;
		
		  StringBuffer sb1 = new StringBuffer("Amit");
		  StringBuffer sb2 = new StringBuffer("Amit");
		  String ss1 = "Amit";
		  System.out.println(sb1==sb2);//FALSE
		  System.out.println(sb1.equals(sb2));//TRUE
		  System.out.println(sb1.equals(ss1));//TRUE
		  System.out.println("Poddar".substring(3));//dar 
		  
		  
		  String s1 = new String("Amit");
		  String s2 = new String("Amit");
		  System.out.println(ss1.equals(s2));
		
	}

}
