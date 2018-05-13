package Tree;

import java.util.LinkedList;

public class PopulateNextRightPointerTree {

	public static void main(String[] args) {
		LinkedList<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(null);
	}

	LinkedList<TreeLinkNode> queue = new LinkedList<>();

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null)
			queue.offer(root.left);
		if (root.right != null)
			queue.offer(root.right);
		queue.offer(null);
		while(queue.size()!=0 &&!(queue.size()==1 && queue.peek()==null)){
			TreeLinkNode node=queue.poll();
			if(node==null)
				queue.offer(null);
			else{
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
			node.next=queue.peek();
			}
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}