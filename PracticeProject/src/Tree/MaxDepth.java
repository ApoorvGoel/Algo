package Tree;

public class MaxDepth {

	public static void main(String[] args) {

	}
	 public int maxDepth(TreeNode A) {
	 if(A==null)
		 return 0;
	 else{
		 int a=maxDepth(A.left);
		 int b=maxDepth(A.right);
		 return 1+Math.max(a,b);
	 }
	 }
}
/* class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) {
	       val = x;
	       left=null;
	       right=null;
	      }
	  }*/