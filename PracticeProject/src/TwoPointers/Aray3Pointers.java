package TwoPointers;

import java.util.List;

public class Aray3Pointers {

	public static void main(String[] args) {

	}
	 public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
	        
	        int diff=Integer.MAX_VALUE;
	        int max=0;
	        int min =0;
	        int currDiff=0;
	        for(int x=0,y=0,z=0;x<A.size()&&y<B.size()&&z<C.size();){
	        	max=Math.max(Math.max(A.get(x), A.get(y)),A.get(z));
	        	min=Math.min(Math.min(A.get(x), A.get(y)),A.get(z));
	        	currDiff=max-min;
	        	if(currDiff<diff){
	        		diff=currDiff;
	        		currDiff=(min==A.get(x))?x++:(min==A.get(y))?y++:(min==A.get(z))?z++:0;
	        	}else{
	        		break;
	        	}
	        }
	        
	        return diff;
	    }
}
