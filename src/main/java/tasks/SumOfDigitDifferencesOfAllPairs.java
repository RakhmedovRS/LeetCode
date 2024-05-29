package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-28
 */
@LeetCode(
		id = 3153,
		name = "Sum of Digit Differences of All Pairs",
		url = "https://leetcode.com/problems/sum-of-digit-differences-of-all-pairs/description/",
		difficulty = Difficulty.MEDIUM
)
public class SumOfDigitDifferencesOfAllPairs {
	public long sumDigitDifferences(int[] nums) {
		int len = 0;
		int num = nums[0];
		while (num > 0) {
			len++;
			num /= 10;
		}

		int[][] memo = new int[len][10];
		addNum(memo, nums[0]);

		long ans = 0;
		for (int i = 1; i < nums.length; i++) {
			num = nums[i];
			for (int j = len - 1; j >= 0; j--) {
				for (int pos = 0; pos < 10; pos++) {
					if (pos != num % 10) {
						ans += memo[j][pos];
					}
				}

				num /= 10;
			}
			addNum(memo, nums[i]);
		}

		return ans;
	}

	private void addNum(int[][] memo, int num) {
		for (int i = memo.length - 1; i >= 0; i--) {
			memo[i][num % 10]++;
			num /= 10;
		}
	}
}