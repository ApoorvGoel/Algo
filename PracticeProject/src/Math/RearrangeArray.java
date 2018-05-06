package Math;

import java.util.ArrayList;

public class RearrangeArray {

	public static void main(String[] args) {

	}
	public void arrange(ArrayList<Integer> a) {
	    int temp=0;
	    int n=a.size();
	    for(int i=0;i<n;i++){
	        temp=a.get(a.get(i))%n;
	        a.set(i,(n*temp)+a.get(i));
	    }
	    
	     for(int i=0;i<n;i++){
	        a.set(i,a.get(i)/n);
	    }
	    
	}
}
