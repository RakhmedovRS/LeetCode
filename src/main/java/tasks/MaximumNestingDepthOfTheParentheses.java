package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 10/11/2020
 */
@LeetCode(id = 1614, name = "Maximum Nesting Depth of the Parentheses", url = "https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/")
public class MaximumNestingDepthOfTheParentheses {
	public int maxDepth(String s) {
		int maxDepth = 0;
		Deque<Character> deque = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				deque.add(ch);
				maxDepth = Math.max(maxDepth, deque.size());
			}
			else if (ch == ')') {
				deque.remove();
			}
		}

		return maxDepth;
	}
}
