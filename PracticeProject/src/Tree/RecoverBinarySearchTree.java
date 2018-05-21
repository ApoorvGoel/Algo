package Tree;

import java.util.ArrayList;
import java.util.Collections;

//Here in this approach we have used O(n) extra space in worst case.(Using recursion). We can avoid the same by using threaded BST.
public class RecoverBinarySearchTree {

	public static void main(String[] args) {

	}

	ArrayList<Integer> result = new ArrayList<Integer>();

	public ArrayList<Integer> recoverTree(TreeNode A) {
		inOrder(A);
		Collections.sort(result);
		return result;
	}

	Integer prev = null;
	int counter = 0;

	public void inOrder(TreeNode A) {
		if (A == null)
			return;
		inOrder(A.left);
		if (prev == null)
			prev = A.val;
		else {
			if (counter == 1) {
				if (A.val < prev) {
					result.remove(0);
					result.add(A.val);
					counter++;
					prev = A.val;
					return;
				}

			}
			if (counter == 0) {
				if (A.val < prev) {
					result.add(A.val);
					result.add(prev);
					counter++;
				}
				// prev=A.val;
			}
			prev = A.val;
		}
		inOrder(A.right);
	}
}
