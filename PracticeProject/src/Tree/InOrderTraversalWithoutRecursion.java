package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class InOrderTraversalWithoutRecursion {

	public static void main(String[] args) {

	}

	LinkedList<TreeNode> stack = new LinkedList<>();

	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A == null)
			return null;

		while (A.left != null) {
			stack.push(A);
			A = A.left;
		}
		while (A != null) {
			result.add(A.val);
			while (A.right != null) {
				A = A.right;
				while (A.left != null) {
					stack.push(A);
					A = A.left;
				}
				result.add(A.val);
			}
			if (stack.size() == 0)
				A = null;
			else
				A = stack.pop();
		}

		return result;
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