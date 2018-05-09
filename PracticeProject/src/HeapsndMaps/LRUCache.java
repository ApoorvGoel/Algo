package HeapsndMaps;

import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, ListNode> hm;
	int maxCap;
	DoublyLL dll;

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(7);
		cache.set(4, 11);
		System.out.println(cache.get(11));
		System.out.println(cache.get(5));
		System.out.println(cache.get(7));
		cache.set(1, 13);
		System.out.println(cache.get(4));
		cache.set(1, 5);
		cache.set(14, 1);
		cache.set(4, 2);
		cache.set(11, 12);
		System.out.println(cache.get(14));
		cache.set(3, 2);
		// System.out.println(cache.get(6));
		System.out.println(cache.get(10));
		cache.set(1, 15);
		System.out.println(cache.get(4));
		cache.set(1, 12);
		System.out.println(cache.get(9));
		System.out.println(cache.get(7));
		System.out.println(cache.get(7));
		System.out.println(cache.get(13));
		System.out.println(cache.get(11));
		System.out.println(cache.get(2));
		System.out.println(cache.get(10));
		cache.set(3,9);
		System.out.println(cache.get(4));
		System.out.println(cache.get(9));
		System.out.println(cache.get(12));
		System.out.println(cache.get(8));
		System.out.println(cache.get(1));
		System.out.println(cache.get(6));
		cache.set(13,8);

		System.out.println(cache.get(4));
		System.out.println(cache.get(15));
		cache.set(5,3);
		System.out.println(cache.get(12));
		
		cache.set(4,8);
		System.out.println(cache.get(10));
		System.out.println(cache.get(5));
		cache.set(9,3);
		cache.set(2,2);
		cache.set(11,9);
		
		System.out.println(cache.get(9));
		System.out.println(cache.get(2));
		cache.set(6,3);
		System.out.println(cache.get(3));

		cache.set(15,8);
		System.out.println(cache.get(2));
	}

	public LRUCache(int capacity) {
		hm = new HashMap<>(capacity);
		maxCap = capacity;
		dll = new DoublyLL(capacity);
	}

	public int get(int key) {
		if (hm.containsKey(key)) {
			dll.moveElementToTop(hm.get(key));
			return hm.get(key).val;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (hm.containsKey(key)) {
			dll.moveElementToTop(hm.get(key));
			hm.get(key).val = value;
		} else {
			ListNode node = new ListNode(key, value);
			ListNode prevNode = dll.addElement(node);
			if (prevNode != null) {
				hm.remove(prevNode.key);
			}
			hm.put(key, node);
		}
	}
}

class ListNode {
	int key;
	int val;
	ListNode next;
	ListNode prev;

	public ListNode(int key, int val) {
		this.key = key;
		this.val = val;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}

class DoublyLL {
	ListNode list;
	ListNode tail;
	ListNode head;
	int maxCapacity;
	int size;

	public DoublyLL(int capacity) {
		this.maxCapacity = capacity;
	}

	public void moveElementToTop(ListNode node) {
		if (node == tail)
			return;
		if (node.prev == null) {
			head = head.next;
			head.prev = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		tail.next = node;
		node.prev=tail;
		tail = tail.next;
		tail.next = null;
		// System.out.println(head);
	}

	public ListNode addElement(ListNode node) {
		if( (head == null && tail == null) ){
			head = tail = node;
			size++;
			// System.out.println(head);
			return null;
		}
		if(maxCapacity==1) {
			ListNode prevNode = head;
			head = tail = node;
			size++;
			// System.out.println(head);
			return prevNode;
		}
		if (size < maxCapacity) {
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
			size++;
			// System.out.println(head);
			return null;
		} else {
			ListNode prevNode = head;
			head = head.next;
			head.prev = null;
			tail.next = node;
			tail = tail.next;
			// System.out.println(head);
			return prevNode;
		}
	}
}
