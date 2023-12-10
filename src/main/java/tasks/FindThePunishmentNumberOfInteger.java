package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/20/2023
 */
@LeetCode(
		id = 2698,
		name = "Find the Punishment Number of an Integer",
		url = "https://leetcode.com/problems/find-the-punishment-number-of-an-integer/",
		difficulty = Difficulty.MEDIUM
)
public class FindThePunishmentNumberOfInteger {
	public int punishmentNumber(int n) {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			if (canSplit(0, String.valueOf(i * i).toCharArray(), 0, i)) {
				num += i * i;
			}
		}

		return num;
	}

	private boolean canSplit(int pos, char[] num, int sum, int target) {
		if (pos >= num.length) {
			return sum == target;
		}

		int curr = 0;
		while (pos < num.length) {
			curr *= 10;
			curr += (num[pos] - '0');
			if (canSplit(pos + 1, num, sum + curr, target)) {
				return true;
			}
			pos++;
		}

		return false;
	}
}
