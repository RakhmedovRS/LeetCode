package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 3/9/2024
 */
@LeetCode(
		id = 3075,
		name = "Maximize Happiness of Selected Children",
		url = "https://leetcode.com/problems/maximize-happiness-of-selected-children/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximizeHappinessOfSelectedChildren {
	public long maximumHappinessSum(int[] happiness, int k) {
		long ans = 0;
		int decrement = 0;
		Arrays.sort(happiness);
		for (int i = happiness.length - 1; i >= 0 && k > 0; i--, k--) {
			if (happiness[i] - decrement <= 0) {
				break;
			}

			ans += (happiness[i] - decrement);

			decrement++;
		}

		return ans;
	}
}
