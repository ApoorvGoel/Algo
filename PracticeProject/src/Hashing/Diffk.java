package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Diffk {

	
	public static void main(String[] args) {
		
		List<Integer> A = new ArrayList<>();
		A.add(34);
		A.add( 63);
		A.add( 64);
		A.add( 38);
		A.add( 65);
		A.add( 83);
		A.add( 50);
		A.add( 44);
		A.add( 18);
		A.add( 34);
		A.add( 71);
		A.add( 80);
		A.add( 22);
		A.add( 28);
		A.add( 20);
		A.add( 96);
		A.add( 33);
		A.add( 70);
		A.add( 0);
		A.add( 25);
		A.add( 64);
		A.add( 96);
		A.add( 18);
		A.add( 2);
		A.add( 53);
		A.add( 100);
		A.add( 24);
		A.add( 47);
		A.add( 98);
		A.add( 69);
		A.add( 60);
		A.add( 55);
		A.add( 8);
		A.add( 38);
		A.add( 72);
		A.add( 94);
		A.add( 18);
		A.add( 68);
		A.add( 0);
		A.add( 53);
		A.add( 18);
		A.add( 30);
		A.add( 86);
		A.add( 55);
		A.add( 13);
		A.add( 93);
		A.add( 15);
		A.add( 43);
		A.add( 73);
		A.add( 68);
		A.add( 29 );
		
		System.out.println(new Diffk().diffPossible(A, 97));

	}
	public int diffPossible(final List<Integer> A, int B) {
        if(A.size()==1)
            return 0;
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0;i<A.size();i++)
            hm.add(A.get(i));
           System.out.println(hm); 
        if(B==0)
            {
                if(A.size()==hm.size())
                    return 0;
                else
                    return 1;
            }
        
        
        
        for(int i=0;i<A.size();i++)
            {
             if(hm.contains(B-A.get(i))|| hm.contains(A.get(i)-B)){
            	 System.out.println(B);
            	 System.out.println(A.get(i));
            	 System.out.println(i);
            	 System.out.println(hm.contains(B-A.get(i)));
            	 System.out.println( hm.contains(A.get(i)-B));
            	 return 1; 
             }
                
            }
        return 0;
    }
}
