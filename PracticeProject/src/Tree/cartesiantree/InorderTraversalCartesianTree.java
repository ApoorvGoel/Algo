package Tree.cartesiantree;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderTraversalCartesianTree {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(ArrayList<Integer> A) {
		int[] parent = new int[A.size()];
		int[] leftChild = new int[A.size()];
		int[] rightChild = new int[A.size()];
		// 'root' and 'last' stores the index of the root and the
		// last processed of the Cartesian Tree.
		// Initially we take root of the Cartesian Tree as the
		// first element of the input array. This can change
		// according to the algorithm
		int root = 0, last = -1;
		Arrays.fill(parent, -1);
		Arrays.fill(leftChild, -1);
		Arrays.fill(rightChild, -1);
		
		// Starting from the second element of the input array
		// to the last on scan across the elements, adding them
		// one at a time.
		for (int i = 1; i < A.size() ; i++) {
			last = i - 1;
			rightChild[i] = -1;
			// scan upwards from the node's parent up to the root of the tree
			// until a node is found whose value is
			// smaller then the current one
			while(A.get(last)<=A.get(i) && last!=root){
				last=parent[last];
			}
			
			//If A.get(i> is the smallest element yet. Make it new root
			
			if(A.get(last)<=A.get(i)){
				parent[root]=i;
				leftChild[i]=root;
				root=i;
			}else if(rightChild[last]==-1){
				rightChild[last]=i;
				parent[i]=last;
				leftChild[i]=-1;
			}
			else{
				parent[rightChild[last]]=i;
				leftChild[i]=rightChild[last];
				rightChild[last]=i;
				parent[i]=last;
			}
		}
		parent[root]=-1;

		return buildCartesianTreeUtil(root, A, parent, leftChild, rightChild);
	}
	
	public TreeNode buildCartesianTreeUtil(int root,ArrayList<Integer> A, int parent[],int leftChild[],int rightChild[]){
		if(root==-1)
			return null;
		TreeNode node = new TreeNode(A.get(root));
		node.left=buildCartesianTreeUtil(leftChild[root], A, parent, leftChild, rightChild);
		node.right=buildCartesianTreeUtil(rightChild[root], A, parent, leftChild, rightChild);
		return node;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}