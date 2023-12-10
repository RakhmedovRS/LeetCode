package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 8/8/2021
 */
@LeetCode(
		id = 1963,
		name = "Minimum Number of Swaps to Make the String Balanced",
		url = "https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfSwapsToMakeTheStringBalanced {
	public int minSwaps(String s) {
		LinkedList<Character> characters = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			if (ch == '[') {
				characters.addLast(ch);
			}
			else if (ch == ']' && !characters.isEmpty() && characters.getLast() == '[') {
				characters.removeLast();
			}
		}

		if (characters.size() % 2 == 0) {
			return characters.size() / 2;
		}
		else {
			return (characters.size() + 1) / 2;
		}
	}
}
