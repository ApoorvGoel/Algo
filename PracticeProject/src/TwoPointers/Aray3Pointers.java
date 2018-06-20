package TwoPointers;

import java.util.List;
/*
 * 
 * 

You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;

Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 


Hint==
        Iterate over all elements of a,
        Binary search for element just smaller than or equal to in b and c, and note the difference.
        Repeat the process for b and c. O(n log n).
*Note: As we move over the element in a, the elements in b and c that we are trying to find will also move forward. *
*
*
*Windowing strategy works here.
Lets say the arrays are A,B and C.

        Take 3 pointers X, Y and Z
        Initialize them to point to the start of arrays A, B and C
        Find min of X, Y and Z.
        Compute max(X, Y, Z) - min(X, Y, Z).
        If new result is less than current result, change it to the new result.
        Increment the pointer of the array which contains the minimum.

Note that we increment the pointer of the array which has the minimum, because our goal is to decrease the difference. Increasing the maximum pointer is definitely going to increase the difference. Increase the second maximum pointer can potentially increase the difference ( however, it certainly will not decrease the difference ).
 */
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
