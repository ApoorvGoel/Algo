package HeapsndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		MergeKSortedLists mks = new MergeKSortedLists();
		ListNode ll = mks.new ListNode(10);
		ListNode ll1 = mks.new ListNode(11);
		ListNode ll2 = mks.new ListNode(12);
		ListNode ll3 = mks.new ListNode(13);
		ListNode ll4 = mks.new ListNode(14);
		ListNode ll5 = mks.new ListNode(15);
		ListNode ll6 = mks.new ListNode(16);
		ListNode ll7 = mks.new ListNode(17);

		ll.next = ll1;
		ll1.next = ll7;

		ll2.next = ll3;
		ll3.next = ll4;
		ll4.next = ll5;
		ll5.next = ll6;
		// System.out.println(ll);
		// System.out.println(ll2);
		ArrayList<ListNode> a = new ArrayList<MergeKSortedLists.ListNode>();
	//	a.add(ll7);
		a.add(ll);
		a.add(ll2);

		System.out.println(mks.mergeKLists(a));
		// System.out.println(mks.merge2Lists(ll, ll2));
		// merge2Lists
	}

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

	class ListComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			int io1 = o1.val;
			int io2 = o2.val;
			return Integer.compare(io1, io2);
		}
	}

	PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListComparator());

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		if (a == null || a.size() == 0)
			return null;

		ListNode c = null;
		ListNode result = null;
		minHeap.addAll(a);
		c = minHeap.poll();
		result = c;
		while (c.next == null) {
			if (minHeap.peek() == null)
				return c;
			c.next = minHeap.poll();
			c = c.next;
		}
		minHeap.offer(c.next);
		
		while (c != null) {
			c.next = minHeap.poll();
			c = c.next;
			if(c==null || c.next==null)
				continue;
			
			minHeap.offer(c.next);
		}

		return result;
	}

	// bug in following inputs: - null pointer exception

	// 10 9 8 20 38 44 55 65 66 79 87 2 68 72 5 5 55 61 73 89 2 30 73 4 28 73 84
	// 96 3 54 82 83 5 15 33 38 94 100 1 4 5 22 32 42 64 86 2 11 78

	public ListNode merge2Lists(ListNode a, ListNode b) {
		ListNode c = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a != null && a.next != null && b != null & b.next != null)
			if (a.val > b.val) {
				c = b;
				b = b.next;
			} else {
				c = a;
				a = a.next;
			}
		ListNode result = c;
		while (a != null && b != null) {
			if (a.val > b.val) {
				c.next = b;
				b = b.next;
			} else {
				c.next = a;
				a = a.next;
			}
			c = c.next;
		}

		while (a != null) {
			c.next = a;
			a = a.next;
		}
		while (b != null) {
			c.next = a;
			a = a.next;
		}

		return result;
	}

}
