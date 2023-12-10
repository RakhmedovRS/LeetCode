package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2/28/2023
 */
@LeetCode(
		id = 2575,
		name = "Find the Divisibility Array of a String",
		url = "https://leetcode.com/problems/find-the-divisibility-array-of-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheDivisibilityArrayOfString {
	public int[] divisibilityArray(String word, int m) {
		long val = 0;
		int[] answer = new int[word.length()];
		for (int i = 0; i < word.length(); i++) {
			val *= 10;
			val += word.charAt(i) - '0';
			val %= m;

			if (val == 0) {
				answer[i] = 1;
			}
		}

		return answer;
	}
}
