package Tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public int isBalanced(TreeNode A) {
		if (A == null)
			return 1;
		int deapthLeft = deapth(A.left);
		int deapthRight = deapth(A.right);
		int diff = deapthLeft - deapthRight;
		if (diff >= -1 && diff <= 1)
			return isBalanced(A.left) & isBalanced(A.right);
		else
			return 0;
	}

	public int deapth(TreeNode A) {
		if (A == null)
			return 0;
		int deapthLeft = deapth(A.left);
		int deapthRight = deapth(A.right);
		return 1 + Math.max(deapthLeft, deapthRight);
	}
}
/*
 * class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; left=null; right=null; } }
 */