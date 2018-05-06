package ll;

public class ReorderLL {

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
		ReorderLL rol = new ReorderLL();
		ListNode ll1=rol.new ListNode(1);
		ListNode ll2=rol.new ListNode(2);
		ListNode ll3=rol.new ListNode(3);
		ListNode ll4=rol.new ListNode(4);
		ListNode ll5=rol.new ListNode(5);
		ListNode ll6=rol.new ListNode(6);
		ListNode ll7=rol.new ListNode(7);

		ll1.next=ll2;
		ll2.next=ll3;
		ll3.next=ll4;
		//ll4.next=ll5;
		ll5.next=ll6;
		ll6.next=ll7;
	//	System.out.println(rol.reverseLL(ll4));
	/*	System.out.println(ll1);
		System.out.println(rol.findMid(ll1));
		System.out.println(rol.reverseLL(ll1));*/
		/*System.out.println(rol.reorderList(ll1));*/
		
		rol.mergeLL(ll1, ll5);
		System.out.println(ll1);
	}
	
	public ListNode divideLLInto2(ListNode A){
		ListNode p=A;
		ListNode q=A;
		while(p.next!=null &&q.next!=null &&q.next.next!=null)
		{
			p=p.next;
			q=q.next.next;
		}
		q=p;
		if(q!=null){
			p=p.next;
			q.next=null;
		}
		return p;
	}
	
	public ListNode reverseLL(ListNode A){
		ListNode	p = null;
		ListNode q=A;
		ListNode r=A;
		if(A!=null){
			r=r.next;
		}
		while(q!=null){
			q.next=p;
			p=q;
			q=r;
			if(r!=null)
				r=r.next;
		}
		return p;
	}
	public void mergeLL(ListNode ll1, ListNode ll2){
		while(ll1!=null && ll2!=null ){
			ListNode temp =ll1.next;
			ll1.next=ll2;
			ll1=ll1.next;
			ll2=ll2.next;
			ll1.next=temp;
			ll1=ll1.next;
		}
		/*if(ll2!=null && ll1.next!=null){
			ListNode temp =ll1.next;
			ll1.next=ll2;
			ll1=ll1.next;
			ll1.next=ll2;
		}else if(ll2!=null){
			ll1.next=ll2;
		}*/
	}
	
	public ListNode reorderList(ListNode A) {
		ListNode ll1=divideLLInto2(A);
		ListNode ll2=reverseLL(ll1);
		mergeLL(A,ll2);
		return A;
	}
}
