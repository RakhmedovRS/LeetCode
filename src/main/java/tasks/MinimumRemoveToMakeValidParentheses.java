package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(
		id = 1249,
		name = "Minimum Remove to Make Valid Parentheses",
		url = "https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumRemoveToMakeValidParentheses {
	public String minRemoveToMakeValid(String s) {
		boolean[] keep = new boolean[s.length()];

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				list.addLast(i);
			}
			else if (s.charAt(i) == ')') {
				if (list.isEmpty()) {
					keep[i] = false;
				}
				else {
					keep[list.removeLast()] = true;
					keep[i] = true;
				}
			}
			else {
				keep[i] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (keep[i]) {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}
}
