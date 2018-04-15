package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
 */
public class NobleInteger {
	 public int solve(ArrayList<Integer> A) {
	       Collections.sort(A, Collections.reverseOrder());
	        
	        if(A.size()==0)
	        return -1;
	         int max=A.get(0);
	         if(max==0)
	            return 1;
	        if(max<0)
	            return -1;
	        
	        ArrayList<Integer> al =new ArrayList<Integer>();
	        for(int i =0;i<=max;i++)
	        {
	            al.add(0);
	            
	        }
	        
            for (int i=0;i<A.size()&&i<al.size();i++){
	                int var=A.get(i);
	                if(var>=0)
	                al.set(var,al.get(var)+1);
	            }
	            int sum=0;
	            for(int i=al.size()-1;i>=0;i--){
	                if(sum==i && al.get(i)!=0)
	                    return 1;
	                sum=sum+al.get(i);
	            }
	            return -1;
	        }
}
