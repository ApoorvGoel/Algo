package Tree;

public class LCA {

	public static void main(String[] args) {

	}

	boolean left;
	boolean right;

	public int lca(TreeNode A, int B, int C) {
		TreeNode result = lcaUtil(A, B, C);
		return (left && right) ? result.val : -1;
	}

	public TreeNode lcaUtil(TreeNode A, int B, int C) {
		if (A == null)
			return null;
		if (A.val == B) {
			left = true;
			right = right || checkNodeExist(A,C);
			return A;
		}
		if (A.val == C) {
			right = true;
			left=left || checkNodeExist(A,B);
			return A;
		}
		TreeNode lNode = lcaUtil(A.left, B, C);
		TreeNode rNode = lcaUtil(A.right, B, C);

		if (lNode != null && rNode != null) {
			return A;
		}
		if (lNode != null)
			return lNode;
		return rNode;
	}
	
	
	public boolean checkNodeExist(TreeNode A, int B){
		if(A==null)
			return false;
		if(A.val==B)
			return true;
		else return checkNodeExist(A.left,B)||checkNodeExist(A.right,B);
	}

}
