package Math;

public class Combinations {

	public static void main(String[] args) {

	}
	
	// Method 1 ----- Direct approach but efficiently.  (uses maths, and may contain overflow issues.).. Time complexity -- o(n)
	long  C(int n, int r) {
	    if(r > n / 2) r = n - r; // because C(n, r) == C(n, n - r)
	    long  ans = 1;
	    int i;

	    for(i = 1; i <= r; i++) {
	        ans *= n - r + i;
	        ans /= i;
	    }

	    return ans;
	}
	
	
	
	//Method 2 ---Using Pascals triangle approach --- space complexity O(n^2).. Time complexity - O(n^2)
	long triangle[][]= new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
	void makeTriangle() {
	    int i, j;

	    // initialize the first row
	    triangle[0][0] = 1; // C(0, 0) = 1

	    for(i = 1; i < Integer.MAX_VALUE; i++) {
	        triangle[i][0] = 1; // C(i, 0) = 1
	        for(j = 1; j <= i; j++) {
	            triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
	        }
	    }
	}

	 long getC(int n, int r) {
	    return triangle[n][r];
	}
	 
	 
	//Method 3  ---Using Pascals triangle approach --- space complexity O(n)  Time complexity - O(n^2)
	 int row[] = new int[Integer.MAX_VALUE];
	 int getCwithSpaceOn(int n, int r) {
		    int i, j;

		    // initialize by the first row
		    row[0] = 1; // this is the value of C(0, 0)

		    for(i = 1; i <= n; i++) {
		        for(j = i; j > 0; j--) {
		             // from the recurrence C(n, r) = C(n - 1, r - 1) + C(n - 1, r)
		             row[j] += row[j - 1];
		        }
		    }

		    return row[r];
		}
	 
	 
	 // Method 4 -- recursive Pascals's Triangle approach
	 
	 long nck[][] = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
	 
	 long choose(int n, int k)
	 {
	     if (k > n)
	         return 0;
	     if (n <= 1)
	         return 1;
	     if (k == 0)
	         return 1;
	  
	     if (nck[n][k] != -1)
	         return nck[n][k];
	  
	     long answer = choose(n - 1, k - 1) + choose(n - 1, k);
	     nck[n][k] = answer;
	     return answer;
	 }
}
