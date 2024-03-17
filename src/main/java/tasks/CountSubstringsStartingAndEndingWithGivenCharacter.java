package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/16/2024
 */
@LeetCode(
		id = 3081,
		name = "Count Substrings Starting and Ending with Given Character",
		url = "https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountSubstringsStartingAndEndingWithGivenCharacter {
	public long countSubstrings(String s, char c) {
		long count = 0;
		for (char ch : s.toCharArray()) {
			if (c == ch) {
				count++;
			}
		}

		return count * (count + 1) / 2;
	}
}
