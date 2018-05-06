package ll;

import ll.ReorderLL.ListNode;

public class InsertionSortLL {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

	}

	public static void main(String[] args) {
		InsertionSortLL rol = new InsertionSortLL();
		ListNode ll1 = rol.new ListNode(5);
		ListNode ll2 = rol.new ListNode(3);
		ListNode ll3 = rol.new ListNode(2);
		ListNode ll4 = rol.new ListNode(4);
		ListNode ll5 = rol.new ListNode(1);
		ListNode ll6 = rol.new ListNode(68);
		ListNode ll7 = rol.new ListNode(79);

		ll1.next = ll2;
		ll2.next = ll3;
		ll3.next = ll4;
		ll4.next = ll7;
		ll7.next = ll5;
		ll5.next = ll6;

		System.out.println(ll1);
		System.out.println(rol.insertionSortList(ll1));
	}

	public ListNode insertInPosition(ListNode A, ListNode itr) {
		ListNode prev = A;
		ListNode temp1 = A;
		// System.out.println(itr.next);
		if (A == itr) {
			prev = A.next;
			A.next = A.next.next;
			prev.next = A;
			return prev;

		}
		if (A.val > itr.next.val) {
			temp1 = itr.next;
			itr.next = itr.next.next;
			temp1.next = A;
			return temp1;
		}

		while (A != itr.next) {
			//System.out.println(A.val);
			//System.out.println(itr.next.val);
			if (A.val > itr.next.val) {
				break;
			}
			prev = A;
			A = A.next;
		}
		// System.out.println(prev);
		ListNode temp = prev.next;
		prev.next = itr.next;
		prev = prev.next;
		ListNode temp2 = itr.next.next;
		prev.next = temp;
		itr.next = temp2;

		// System.out.println(prev);
		return temp1;
	}

	public ListNode insertionSortList(ListNode A) {
		if (A == null)
			return A;

		ListNode itr = A;
		while (itr.next != null) {
			// System.out.println(A);
			if (itr.next.val < itr.val) {
				// System.out.println(itr.next.val);
				A = insertInPosition(A, itr);
			} else {
				itr = itr.next;
			}

		}
		return A;
	}
}
