package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/30/2023
 */
@LeetCode(
		id = 2981,
		name = "Find Longest Special Substring That Occurs Thrice I",
		url = "https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindLongestSpecialSubstringThatOccursThriceI {
	public int maximumLength(String s) {
		int longest = -1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			String pattern = "";
			for (int len = 1; len <= s.length(); len++) {
				pattern += ch;
				int seen = 0;
				int index = 0;
				while (seen < 3 && index != -1) {
					int nextIndex = s.indexOf(pattern, index);
					if (nextIndex == -1) {
						break;
					}
					index = nextIndex + 1;
					seen++;
				}

				if (seen == 3) {
					longest = Math.max(longest, len);
				} else {
					break;
				}
			}
		}

		return longest;
	}
}
