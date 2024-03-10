package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 3/9/2024
 */
@LeetCode(
		id = 3074,
		name = "Apple Redistribution into Boxes",
		url = "https://leetcode.com/problems/apple-redistribution-into-boxes/",
		difficulty = Difficulty.EASY
)
public class AppleRedistributionIntoBoxes {
	public int minimumBoxes(int[] apple, int[] capacity) {
		int sum = 0;
		for (int appl : apple) {
			sum += appl;
		}

		int ans = 0;
		Arrays.sort(capacity);
		for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
			sum -= capacity[i];
			ans++;
		}

		return ans;
	}
}
