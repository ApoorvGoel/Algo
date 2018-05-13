package Tree;

public class Foldable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data=data;
		left=right=null;
	}
}
class BinaryTree{
	Node root;
	
	boolean isFoldable(Node node){
		boolean res;
		
		if(node==null)
			return true;
		return true;
	}
}