package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-27
 */
@LeetCode(
		id = 3019,
		name = "Number of Changing Keys",
		url = "https://leetcode.com/problems/number-of-changing-keys/description/",
		difficulty = Difficulty.EASY
)
public class NumberOfChangingKeys {
	public int countKeyChanges(String s) {
		s = s.toLowerCase();
		char prev = s.charAt(0);
		int switches = 0;
		for (char ch : s.toCharArray()) {
			if (ch != prev) {
				switches++;
			}

			prev = ch;
		}

		return switches;
	}
}