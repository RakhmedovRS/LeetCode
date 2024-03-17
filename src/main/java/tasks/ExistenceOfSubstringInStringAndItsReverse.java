package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/16/2024
 */
@LeetCode(
		id = 3083,
		name = "Existence of a Substring in a String and Its Reverse",
		url = "https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/",
		difficulty = Difficulty.EASY
)
public class ExistenceOfSubstringInStringAndItsReverse {
	public boolean isSubstringPresent(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		for (int i = 1; i < s.length(); i++) {
			if (reverse.contains(s.substring(i - 1, i + 1))) {
				return true;
			}
		}

		return false;
	}
}
