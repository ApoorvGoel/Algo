package ll;

public class ListCycle {
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}

	}

	public static void main(String[] args) {
		ListNode ll = new ListNode(11);
		ListNode ll1 = new ListNode(87797);
		ListNode ll2 = new ListNode(23219);
		ListNode ll3 = new ListNode(41441);
		ListNode ll4 = new ListNode(58396);
		ListNode ll5 = new ListNode(48953);
		ListNode ll6 = new ListNode(94603);
		ListNode ll7 = new ListNode(2721);
		ListNode ll8 = new ListNode(95832);
		ListNode ll9 = new ListNode(49029);
		ListNode ll10 = new ListNode(98448);
		ListNode ll11 = new ListNode(65450);

		ll.next = ll1;
		ll1.next = ll2;
		ll2.next = ll3;
		ll3.next = ll4;
		ll4.next = ll5;
		ll5.next = ll6;
		ll6.next = ll7;
		ll7.next = ll8;
		ll8.next = ll9;
		ll9.next = ll10;
		ll10.next = ll11;
		ll11.next = ll4;

		System.out.println(new ListCycle().detectCycle(ll));
	}

	
	//Search solution in GeeksforGeek. As the solution is more neat and clean there.
	public ListNode detectCycle(ListNode a) {

		ListNode b = a;
		ListNode c = a;
		if (a == null || a.next == null || a.next.next == null)
			return null;

		a = a.next;
		b = b.next.next;

		if (a == null || a.next == null || a.next.next == null || b == null || b.next == null || b.next.next == null)
			return null;

		while (a != null && b != null && a != b && a.next != null && b.next != null && b.next.next != null) {
			a = a.next;
			b = b.next.next;
		}

		if (a == null || b == null || a.next == null || b.next == null || b.next.next == null)
			return null;

		b = c;
		int n = 1;
		while (b.next != a) {
			b = b.next;
			n++;
		}

		b = c;
		for (int i = 0; i < n; i++) {
			b = b.next;
		}

		while (b != c) {
			c = c.next;
			b = b.next;
		}

		return c;
	}
}
