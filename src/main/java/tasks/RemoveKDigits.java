package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 13-May-20
 */
@LeetCode(
		id = 402,
		name = "Remove K Digits",
		url = "https://leetcode.com/problems/remove-k-digits/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (num == null || num.length() == 0 || num.length() == k) {
			return "0";
		}

		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
				stack.removeFirst();
				k--;
			}

			if (stack.isEmpty() && ch == '0') {
				continue;
			}
			stack.addFirst(num.charAt(i));
		}

		while (k > 0) {
			stack.removeFirst();
			k--;
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.removeFirst());
		}

		String answer = stringBuilder.reverse().toString();
		return answer.isEmpty() ? "0" : answer;
	}
}
