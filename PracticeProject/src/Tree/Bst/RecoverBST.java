package Tree.Bst;

public class RecoverBST {

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode t1 = new TreeNode(6);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(8);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		s.printInorder(t1);
		s.recoverTree(t1);
		System.out.println();
		s.printInorder(t1);

		TreeNode e1 = new TreeNode(8);
		TreeNode e2 = new TreeNode(3);
		TreeNode e3 = new TreeNode(15);
		TreeNode e4 = new TreeNode(2);
		TreeNode e5 = new TreeNode(5);
		TreeNode e6 = new TreeNode(4);
		TreeNode e7 = new TreeNode(18);
		TreeNode e8 = new TreeNode(1);
		TreeNode e9 = new TreeNode(12);
		TreeNode e10 = new TreeNode(6);

		e1.left = e2;
		e1.right = e3;
		e2.left = e4;
		e2.right = e5;
		e3.left = e6;
		e3.right = e7;
		e4.left = e8;
		e5.left = e9;
		e5.right = e10;
		s = new Solution();
		System.out.println();
		s.printInorder(e1);
		s.recoverTree(e1);
		System.out.println();
		s.printInorder(e1);
	}

}

class Solution {

	TreeNode first = null, second = null;
	TreeNode prev = null;

	public void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);

		if (prev != null) {
			if (root.val < prev.val) {
				if (first == null)
					first = prev;
				second = root;
			}
		}
		prev = root;

		inorder(root.right);

	}

	public void printInorder(TreeNode a) {
		if (a == null)
			return;
		printInorder(a.left);
		System.out.print(" " + a.val);
		printInorder(a.right);
	}

	public void recoverTree(TreeNode a) {

		inorder(a);
		/*
		 * if (second == null) { int temp = first.val; first.val = prev.val;
		 * prev.val = temp; } else {
		 */
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
		// }
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
