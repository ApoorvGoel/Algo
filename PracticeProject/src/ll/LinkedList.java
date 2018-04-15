package ll;

public class LinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	public  void reverseTheLL(){
		Node p=null,q=null,r=null;
		p= head;
		q=head.next;
		
		while(q!=null){
			p.next=r;
			r=p;
			p=q;
			q=q.next;
		}
		p.next=r;
		head=p;
	}
	public  void reverseEveryKElementInLL(int k){
		Node p=null,q=null,r=null;
		p=head;
		q=head.next;
		int counter=0;
		while(q!=null && counter!=k){
	
		while(q!=null){
			p.next=r;
			r=p;
			p=q;
			q=q.next;
		}
		p.next=r;
		head=p;
	}
	}
}
