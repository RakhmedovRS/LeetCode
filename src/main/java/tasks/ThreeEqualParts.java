package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/17/2021
 */
@LeetCode(
	id = 927,
	name = "Three Equal Parts",
	url = "https://leetcode.com/problems/three-equal-parts/",
	difficulty = Difficulty.HARD
)
public class ThreeEqualParts
{
	public int[] threeEqualParts(int[] nums)
	{
		int ones = 0;
		for (int num : nums)
		{
			ones += num;
		}

		if (ones == 0)
		{
			return new int[]{0, 2};
		}
		if (ones % 3 != 0)
		{
			return new int[]{-1, -1};
		}

		int idxThird = 0;
		int temp = 0;
		for (int i = nums.length - 1; i >= 0; i--)
		{
			temp += nums[i];
			if (temp == ones / 3)
			{
				idxThird = i;
				break;
			}
		}

		int res1 = findEndIdx(nums, 0, idxThird);
		if (res1 < 0)
		{
			return new int[]{-1, -1};
		}

		int res2 = findEndIdx(nums, res1 + 1, idxThird);
		if (res2 < 0)
		{
			return new int[]{-1, -1};
		}

		return new int[]{res1, res2 + 1};
	}

	private int findEndIdx(int[] nums, int left, int right)
	{
		while (nums[left] == 0)
		{
			left++;
		}
		while (right < nums.length)
		{
			if (nums[left] != nums[right])
			{
				return -1;
			}
			left++;
			right++;
		}
		return left - 1;
	}
}
