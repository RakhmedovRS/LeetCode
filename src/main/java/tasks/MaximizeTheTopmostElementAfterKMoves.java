package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/13/2022
 */
@LeetCode(
	id = 2202,
	name = "Maximize the Topmost Element After K Moves",
	url = "https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/",
	difficulty = Difficulty.MEDIUM
)
public class MaximizeTheTopmostElementAfterKMoves
{
	public int maximumTop(int[] nums, int k)
	{
		int max = -1;
		if (nums.length == 1 && k % 2 != 0)
		{
			return max;
		}

		for (int i = 0; i < Math.min(nums.length, k - 1); i++)
		{
			max = Math.max(max, nums[i]);
		}

		if (k < nums.length)
		{
			max = Math.max(max, nums[k]);
		}

		return max;
	}
}
