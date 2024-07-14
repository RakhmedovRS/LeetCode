package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-13
 */
@LeetCode(
		id = 3216,
		name = "Lexicographically Smallest String After a Swap",
		url = "https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/",
		difficulty = Difficulty.EASY
)
public class LexicographicallySmallestStringAfterSwap {
	public String getSmallestString(String s) {
		char[] chars = s.toCharArray();
		for (int i = 1; i < s.length(); i++) {
			int prev = chars[i - 1] - '0';
			int curr = chars[i] - '0';
			if (prev > curr && (prev % 2 == curr % 2)) {
				chars[i - 1] = (char) (curr + '0');
				chars[i] = (char) (prev + '0');
				break;
			}
		}
		return String.valueOf(chars);
	}
}