package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-08
 */
@LeetCode(
		id = 3174,
		name = "Clear Digits",
		url = "https://leetcode.com/problems/clear-digits/description/",
		difficulty = Difficulty.EASY
)
public class ClearDigits {
	public String clearDigits(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				if (sb.length() != 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}