package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/26/2023
 */
@LeetCode(
		id = 2834,
		name = "Find the Minimum Possible Sum of a Beautiful Array",
		url = "https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheMinimumPossibleSumOfBeautifulArray {
	public long minimumPossibleSum(int n, int target) {
		long sum = ((long) n * (n + 1)) / 2;

		long neg = 0;
		long shift = 0;
		int max = n;
		long half = (target % 2 == 0 ? target / 2 : target / 2 + 1);
		for (int i = 1; i < half && max >= half; i++) {
			neg += (target - i);
			shift++;
			max++;
		}

		if (shift > 0) {
			sum = ((n + shift) * ((n + shift) + 1)) / 2 - neg;
		}

		return sum;
	}
}
