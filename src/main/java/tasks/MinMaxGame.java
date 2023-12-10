package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/13/2022
 */
@LeetCode(
		id = 2293,
		name = "Min Max Game",
		url = "https://leetcode.com/problems/min-max-game/",
		difficulty = Difficulty.EASY
)
public class MinMaxGame {
	public int minMaxGame(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int[] next = new int[nums.length / 2];
		boolean min = true;
		for (int i = 1, pos = 0; i < nums.length; pos++, i += 2) {
			if (min) {
				next[pos] = Math.min(nums[i - 1], nums[i]);
			}
			else {
				next[pos] = Math.max(nums[i - 1], nums[i]);
			}

			min = !min;
		}

		return minMaxGame(next);
	}
}
