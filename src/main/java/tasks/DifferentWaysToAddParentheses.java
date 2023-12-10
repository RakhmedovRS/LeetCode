package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 08-May-20
 */
@LeetCode(id = 241, name = "Different Ways to Add Parentheses", url = "https://leetcode.com/problems/different-ways-to-add-parentheses/")
public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String expression) {
		return diffWaysToCompute(expression, new HashMap<>());
	}

	public List<Integer> diffWaysToCompute(String expression, Map<String, List<Integer>> memo) {
		List<Integer> result = memo.getOrDefault(expression, new ArrayList<>());
		if (!result.isEmpty()) {
			return result;
		}
		for (int i = 0; i < expression.length(); i++) {
			if (!Character.isDigit(expression.charAt(i))) {
				String leftPart = expression.substring(0, i);
				String rightPart = expression.substring(i + 1);
				List<Integer> leftValues = diffWaysToCompute(leftPart, memo);
				List<Integer> rightValues = diffWaysToCompute(rightPart, memo);
				for (Integer left : leftValues) {
					for (Integer right : rightValues) {
						result.add(evaluate(left, right, expression.charAt(i)));
					}
				}
			}
		}

		if (result.isEmpty()) {
			result.add(Integer.parseInt(expression));
		}

		memo.put(expression, result);
		return result;
	}

	private int evaluate(int a, int b, char operator) {
		switch (operator) {
			case '+': {
				return a + b;
			}
			case '-': {
				return a - b;
			}
			default: {
				return a * b;
			}
		}
	}
}
