package stack;

import java.util.LinkedList;

public class ReverseStack {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.push(0);
		ll.push(1);
		ll.push(2);
		ll.push(3);
		System.out.println(ll);
		reverseStack(ll);
		System.out.println(ll);
	}

	static void reverseStack(LinkedList<Integer> ll) {
		int a ;
		if (ll.size() != 0) {
			a = ll.pop();
			reverseStack(ll);
			insertAtBottomOfStack(ll,a);
		}
	}
	static void insertAtBottomOfStack(LinkedList<Integer> ll,int x) {
		if(ll.size()==0)
			ll.push(x);
		else{
			int a= ll.pop();
			insertAtBottomOfStack(ll,x);
			ll.push(a);
		}
	}

}
