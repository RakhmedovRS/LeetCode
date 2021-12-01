package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(
	id = 198,
	name = "House Robber",
	url = "https://leetcode.com/problems/house-robber/",
	difficulty = Difficulty.MEDIUM
)
public class HouseRobber
{
	public int rob(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		else if (nums.length == 1)
		{
			return nums[0];
		}
		else if (nums.length == 2)
		{
			return Math.max(nums[0], nums[1]);
		}
		else
		{
			int[] skip = new int[nums.length];
			int[] take = new int[nums.length];
			take[0] = nums[0];
			for (int i = 1; i < nums.length; i++)
			{
				take[i] = nums[i] + skip[i - 1];
				skip[i] = Math.max(take[i - 1], skip[i - 1]);
			}

			return Math.max(skip[nums.length - 1], take[nums.length - 1]);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
		System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
		System.out.println(new HouseRobber().rob(new int[]{2, 1, 1, 2}));
	}
}
