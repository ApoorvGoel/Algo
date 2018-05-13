package HeapsndMaps;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * 
 * @author apoorv.goel
 *
 *
 *
 *
Problem
=========================
Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link

So now the problem statement for this question is:

How many distinct Max Heap can be made from n distinct integers

In short, you have to ensure the following properties for the max heap :

    Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. )
    Every node is greater than all its children

Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

Following are the possible max heaps from these 4 numbers :

         4 
       /  \ 
      3   2 
     / 
    1

         4 
       /  \ 
      2   3 
     / 
    1

        4 
       /  \ 
      3   1 
     / 
    2

These are the only possible 3 distinct max heaps possible for 4 distinct elements.

Implement the below function to return the number of distinct Max Heaps that is possible from n distinct elements.

As the final answer can be very large output your answer modulo 1000000007

Input Constraints : n <= 100






Solution Approach
========================
    Suppose there are n distinct elements to be used in Max heap. Now it is for sure that the maximum element among this n distinct element will surely be placed on the root of the heap.

    Now there will be remaining (n-1) elements to be arranged.

    Now point to be remembered here is that the structure of the heap will remain the same. That is only the values within the node will change however the overall structure remaining the same.

    As structure of the heap remains the same, the number of elements that are present in the left sub-tree of the root (L) will be fixed. And similarly the number of the elements on the right sub-tree (R) of the root. And also following equality holds .

    L + R = (n-1) 

    Now as all the remaining (n-1) elements are less than the element present at the root(The Max Element), whichever L elements among ‘n-1` elements we put in the left sub-tree, it doesn’t matter because it will satisfy the Max Heap property.

    So now there are (n-1)CL ways to pickup L elements from (n-1) elements. And then recurse the solution.

    So final equation will be as follows :

    (n-1)CL * getNumberOfMaxHeaps(L) * getNumberOfMaxHeaps(R) 

    So now the question remains only of finding L for given n. It can be found as follows:

    Find the height of the heap h = log2(n)

    Find the max number of elements that can be present in the hth level of any heap . Lets call it m. m = 2h

    Find the number of elements that are actually present in last level(hth level) in heap of size n. Lets call it p. p = n - (2h - 1)

    Now if the last level of the heap is more than or equal to exactly half filled, then L would be 2h - 1

    However if it is half filled then it will reduced by the number of elements in last level left to fill exactly half of the last level.

    So final equation for L will be as follows :

    L = 2h - 1 if p >= m/2
                        = 2h - 1 - (m/2 - p) if p<(m/2) 


 *
 *
Common mistakes people make
==============================
    Make sure that candidate understand what is a Heap and Max Heap

    Please refer to hints and give hints when the candidate is stuck

    Make sure the candidate is not considering all posible max heaps(which are not binary tree). Say this for example
    ```

      5											Its a ** Max Heap ** but not a ** Binary Tree **
     / \
    4   1    /   3  / 2

```

    Special care is required for this problem to take care of overflows :
    A few overflow gotchas :
    ** int *= int overflows
    ** long long += int * int overflows
    ** int += long long * long long overflows

    Special care is required for this problem to take care of modulo :
    A few modulo gotchas :
    ** ‘int = (int * int * int)%mod’ overflows
    ** ‘int = (int%mod * int%mod)’ overflows
    While Calculating nCr ‘n!/(r!*(n-r)!)’ may overflow :
    Instead Calculating in this way you may use this property of Combination :

    nCr = n-1Cr + n-1Cr-1
    The return type of log function is double.


 */
public class WaysToFormMaxHeap {
long nc[][];
	public static void main(String[] args) {
		// System.out.println(calculatePower(2,10));
		// System.out.println(findHeightOfTheTree(10));
		System.out.println(new WaysToFormMaxHeap().findMaxHeapPossible(4));
		new WaysToFormMaxHeap().print();
	}
void print(){
	System.out.println(nc);
}
	public int solve(int A) {
		if (A == 1)
			return 1;

		return (int) findMaxHeapPossible(A);
	}

	HashMap<Long, Long> maxHeapPossible = new HashMap<>();

	public long findMaxHeapPossible(long n) {
		if (n <= 1)
			return 1;
		if (maxHeapPossible.get(n) != null) {
			return maxHeapPossible.get(n);
		}
		long height = findHeightOfTheTree(n);
		long maxLeafNodesPossible = findNoOfLeafNodesPossible(height);
		long noOfInnerNodes = maxLeafNodesPossible - 1l;
		long noOfLeafNodes = findNoOfLeafNodes(n, noOfInnerNodes);
		long maxLeafNodesPossibleInLeftSubTree = maxLeafNodesPossible / 2l;
		long noOfNodesInLeftSubTree;
		if (noOfLeafNodes >= maxLeafNodesPossibleInLeftSubTree) {
			noOfNodesInLeftSubTree = noOfInnerNodes;
		} else {
			noOfNodesInLeftSubTree = noOfInnerNodes - (maxLeafNodesPossibleInLeftSubTree - noOfLeafNodes);
		}

		long combi = getCombinations( n - 1l, noOfNodesInLeftSubTree) % 1000000007l;
		long maxHeapPoss = (((((combi) * (findMaxHeapPossible(noOfNodesInLeftSubTree) % 1000000007l))) % 1000000007l) * (findMaxHeapPossible((n - 1) - noOfNodesInLeftSubTree) % 1000000007l)) % 1000000007l;
		if(maxHeapPoss<0)
			maxHeapPoss=Integer.MAX_VALUE;
		maxHeapPossible.put(n, maxHeapPoss);
		return maxHeapPoss;
	}

	HashMap<String, Long> nck = new HashMap<>();

	long getCombinations(long n, long k) {
		if (k > n)
			return 0;
		if (n <= 1)
			return 1;
		if (k == 0)
			return 1;

		String key = n + "." + k;
		if (nck.containsKey(key))
			return nck.get(key);
		long answer = getCombinations(n - 1, k - 1) + getCombinations(n - 1, k);
		answer=answer%1000000007;
		nck.put(key,answer);
		return answer;
	}

	public long findNoOfLeafNodesPossible(long h) {

		return calculatePower(2, h);
	}

	public long calculatePower(long a, long b) {
		if (a <= 1)
			return a;
		if (b <= 1)
			return a;

		long result;
		if (b % 2 == 0) {
			result = calculatePower(a, b / 2) % 1000000007l;
			result = result * result;
		} else {
			result = calculatePower(a, b / 2);
			result = result * result * (a % 1000000007l);
		}
		if(result<0)
			return Integer.MAX_VALUE;
		return result % 1000000007l;
	}

	public long findNoOfLeafNodes(long totalNoOfNodes, long noOfInnerNodes) {
		return totalNoOfNodes - noOfInnerNodes;
	}

	public static long findHeightOfTheTree(long n) {
		long count = 0;
		if (n <= 0)
			return count;
		if (n <= 2)
			return 1;
		while (n != 1) {
			n = n / 2l;
			count++;
		}
		return count;
	}
}
