package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-31
 */
@LeetCode(
		id = 3271,
		name = "Hash Divided String",
		url = "https://leetcode.com/problems/hash-divided-string/description/",
		difficulty = Difficulty.MEDIUM
)
public class HashDividedString {
	public String stringHash(String s, int k) {
		StringBuilder result = new StringBuilder();
		int currentSum = 0;
		for (int i = 0; i < s.length(); i++) {
			currentSum += (s.charAt(i) - 'a');
			if ((i + 1) % k == 0) {
				char ch = (char) ((currentSum % 26) + 'a');
				result.append(ch);
				currentSum = 0;
			}
		}
		return result.toString();
	}
}