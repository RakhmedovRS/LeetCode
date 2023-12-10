package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.IntBinaryOperator;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(
		id = 150,
		name = "Evaluate Reverse Polish Notation",
		url = "https://leetcode.com/problems/evaluate-reverse-polish-notation/",
		difficulty = Difficulty.MEDIUM
)
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		LinkedList<Integer> stack = new LinkedList<>();
		Map<String, IntBinaryOperator> ops = new HashMap<>();
		ops.put("+", (a, b) -> a + b);
		ops.put("-", (a, b) -> a - b);
		ops.put("*", (a, b) -> a * b);
		ops.put("/", (a, b) -> a / b);

		int a;
		int b;
		for (String token : tokens) {
			if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
				b = stack.pop();
				a = stack.pop();

				stack.push(ops.get(token).applyAsInt(a, b));
			}
			else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.remove();
	}

	public static void main(String[] args) {
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
}
