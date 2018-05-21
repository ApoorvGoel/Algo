package Tree;

public class InvertTheBinaryTree {

	public static void main(String[] args) {
		
	}
	public TreeNode invertTree(TreeNode A) {
		if(A==null)
			return null;
		TreeNode temp =invertTree(A.left);
		A.left=invertTree(A.right);
		A.right=temp;
		return A;
	}
}
