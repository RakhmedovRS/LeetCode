package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
@LeetCode(
		id = 1047,
		name = "Remove All Adjacent Duplicates In String",
		url = "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/",
		difficulty = Difficulty.EASY
)
public class RemoveAllAdjacentDuplicatesInString {
	public String removeDuplicates(String S) {
		Deque<Character> stack = new LinkedList<>();
		for (char ch : S.toCharArray()) {
			if (stack.isEmpty() || stack.peek() != ch) {
				stack.addFirst(ch);
			}
			else {
				stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder(stack.size());
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}
}
