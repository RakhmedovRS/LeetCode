package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 20-Mar-20
 */
@LeetCode(
		id = 20,
		name = "Valid Parentheses",
		url = "https://leetcode.com/problems/valid-parentheses/",
		difficulty = Difficulty.EASY
)
public class ValidParentheses {
	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			else if (ch == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				}

				stack.pop();
			}
			else if (ch == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					return false;
				}

				stack.pop();
			}
			else if (ch == '}') {
				if (stack.isEmpty() || stack.peek() != '{') {
					return false;
				}

				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()[]{}"));
	}
}
