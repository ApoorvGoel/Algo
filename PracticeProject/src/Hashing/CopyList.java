package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CopyList {

 class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public static void main(String[] args) {
		HashSet<RandomListNode> hs = new HashSet<>();
/*		RandomListNode r1 =  new RandomListNode(1);
		hs.add(r1);
		RandomListNode r2 =  new RandomListNode(2);
		hs.add(r2);
		RandomListNode r3 =  new RandomListNode(3);
		hs.add(r3);
		RandomListNode r4 =  new RandomListNode(4);
		hs.add(r4);
		RandomListNode r5 =  new RandomListNode(5);
		hs.add(r5);
		RandomListNode r6 =  new RandomListNode(5);
		System.out.println(hs);
		System.out.println(hs.contains(r3));
		System.out.println(hs.contains(r6));*/

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode,RandomListNode> hm = new HashMap<>();
		
		if(head==null)
			return head;
		
		if(head.next==null){
			return new RandomListNode(head.label);
		}
		RandomListNode newNode1= null;
		RandomListNode newNode2= null;
		RandomListNode resultHead= null;
		RandomListNode temp=head;
		newNode1= new RandomListNode(temp.label);
		resultHead=newNode1;
		while(temp.next!=null){
			hm.put(temp,newNode1);
			temp=temp.next;
			newNode2= new RandomListNode(temp.label);
			newNode1.next=newNode2;
			newNode1=newNode2;
		}
		hm.put(temp,newNode1);
		
		for(RandomListNode randomListNode :hm.keySet()){
			RandomListNode parentNode=randomListNode;
			RandomListNode childNode=hm.get(randomListNode);
			childNode.random=hm.get(parentNode.random);
		}
		
		return resultHead;
	}
}
