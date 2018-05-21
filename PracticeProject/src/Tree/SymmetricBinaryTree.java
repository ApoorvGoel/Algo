package Tree;

public class SymmetricBinaryTree {

	public static void main(String[] args) {

	}
	public int isSymmetric(TreeNode A) {
		if(A==null)
			return 1;
		
		TreeNode newA=copyTree(A);
		TreeNode mirrorA=findMirrorImage(newA);
		
		
		return equals(A,mirrorA);
    }
	
	public TreeNode copyTree(TreeNode A){
		if(A==null)
			return A;
		TreeNode newA= new TreeNode(A.val);
		newA.left=copyTree(A.left);
		newA.right=copyTree(A.right);
		return newA;
	}
	public TreeNode findMirrorImage(TreeNode A){
		if(A==null)
			return null;
		TreeNode temp =findMirrorImage(A.left);
		A.left=findMirrorImage(A.right);
		A.right=temp;
		return A;
	}
	public int equals(TreeNode A,TreeNode B){
		if(A==null && B==null)
			return 1;
		if(A==null || B==null)
			return 0;
		if(A.val==B.val)
			return equals(A.left,B.left)&equals(A.right,B.right);
		return 0;
	}
}

  /*class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }*/
 