package Tree;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode flatten(TreeNode a) {
		if(a==null)
			return a;
		TreeNode node=a;
		
		while(node!=null){
			TreeNode rightMost=node.left;
			if(rightMost!=null){
				while(rightMost.right!=null){
					rightMost=rightMost.right;
				}
				rightMost.right=node.right;
				node.right=node.left;
				node.left=null;
			}
			node=node.right;
		}
		
		
		return a;
	}
}
