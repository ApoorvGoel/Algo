package stack;

import java.util.LinkedList;

public class RedundantBrackets {

	public static void main(String[] args) {
		System.out.println(new RedundantBrackets().braces("((a+b))"));
/*		LinkedList<Character> ll = new LinkedList<>();
		ll.push('a');
		ll.push('b');
		ll.push('c');
		ll.push('d');
		System.out.println(ll.peek());
		ll.pop();
		ll.pop();
		System.out.println(ll.peek());
		ll.pop();
		System.out.println(ll.peek());
		ll.pop();*/
		//System.out.println( '('==null);
	}

	public int braces(String A) {
		LinkedList<Character> ll = new LinkedList<>();

		int i = 0;
		int counter = 0;
		while (i < A.length()) {
			if (!(A.charAt(i) == ')'))
				ll.push(A.charAt(i));
			else {
				while (ll.peek() != null && ll.peek() != '(') {
					Character c = ll.pop();
					if (c == '+' || c == '-' || c == '*' || c == '/')
						counter++;
				}
				if (counter == 0)
					return 1;
				counter = 0;
				ll.pop();
				if (ll.peek() != null && '(' == ll.peek() && (i+1) < A.length() && A.charAt(i+1) == ')')
					return 1;
			}
			i++;
		}
		return 0;
	}

}
