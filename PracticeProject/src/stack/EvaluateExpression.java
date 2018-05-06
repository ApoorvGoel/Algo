package stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class EvaluateExpression {

	public static void main(String[] args) {
		// System.out.println(Character.isDigit("*123".charAt(0)));

		ArrayList<String> A = new ArrayList<>();
		A.add("2");
		A.add("1");
		A.add("+");
		A.add("3");
		A.add("*");

		System.out.println(new EvaluateExpression().evalRPN(A));
	}

	public int evalRPN(ArrayList<String> A) {
		if (A == null || A.size() == 0)
			return -1;
		LinkedList<Integer> operandStack = new LinkedList<>();
		for (String string : A) {
			if (Character.isDigit(string.charAt(0)) || string.length()>1) {
				operandStack.push(Integer.parseInt(string));
			} else {
				int operand1 = operandStack.pop();
				int operand2 = operandStack.pop();
				operandStack.push(doOperation(operand2, operand1, string));
			}
		}
		return operandStack.pop();
	}

	public int doOperation(int operand1, int operand2, String operator) {
		if (operator.equals("+"))
			return operand1 + operand2;
		if (operator.equals("-"))
			return operand1 - operand2;
		if (operator.equals("*"))
			return operand1 * operand2;
		if (operator.equals("/"))
			return operand1 / operand2;
		return -1;
	}
}
