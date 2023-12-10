package tasks;

import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 19-Jun-20
 */
@LeetCode(id = 1190, name = "Reverse Substrings Between Each Pair of Parentheses", url = "https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/")
public class ReverseSubstringsBetweenEachPairOfParentheses {
	public String reverseParentheses(String s) {
		char[] chars = s.toCharArray();
		LinkedList<Integer> openBrackets = new LinkedList<>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				openBrackets.addLast(i);
			}
			else if (chars[i] == ')') {
				reverse(chars, openBrackets.removeLast(), i);
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (char ch : chars) {
			if (ch == '(' || ch == ')') {
				continue;
			}
			stringBuilder.append(ch);
		}

		return stringBuilder.toString();
	}

	private void reverse(char[] chars, int left, int right) {
		while (left < right) {
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
	}
}
