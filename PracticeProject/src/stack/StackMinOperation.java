package stack;

import java.util.LinkedList;

public class StackMinOperation {
	LinkedList<Integer> stack = new LinkedList<>();
	int minElement = Integer.MAX_VALUE;

	public static void main(String[] args) {
		StackMinOperation smo = new StackMinOperation();
/*		smo.stack.push(10);
		smo.stack.push(9);
		smo.stack.push(8);
		smo.stack.push(7);
		System.out.println(smo.stack.peek());
		System.out.println(smo.stack.peekFirst());
		System.out.println(smo.stack.peekLast());
		System.out.println(smo.stack);
		smo.stack.pop();
		System.out.println(smo.stack);*/
		
		smo.push(10);
		smo.push(9);
		smo.push(8);;
		smo.push(7);
		smo.push(6);
		System.out.println(smo.stack);
		System.out.println(smo.getMin());
		
	}

	public void push(int x) {
		if (stack.size() == 0) {
			minElement = x;
		} else if (x < minElement) {
			int temp=x;
			x = minElement - x;
			minElement = temp;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.size() == 0)
			return;
		if (stack.peekLast() < minElement) {
			minElement = stack.peekLast() + minElement;
		}
		stack.pop();
	}

	public int top() {
		if (stack.size() == 0)
			return -1;
		if (stack.peekLast() < minElement) {
			return minElement;
		}
		return stack.peekLast();
	}

	public int getMin() {
		if (stack.size() == 0)
			return -1;
		return minElement;
	}
}
