import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/14/2020
 */
@LeetCode(id = 213, name = "House Robber II", url = "https://leetcode.com/problems/house-robber-ii/")
public class HouseRobberII
{
	public int rob(int[] nums)
	{
		int len = nums.length;
		if (len == 0)
		{
			return 0;
		}
		else if (len == 1)
		{
			return nums[0];
		}
		else if (len == 2)
		{
			return Math.max(nums[0], nums[1]);
		}
		else if (len == 3)
		{
			return Math.max(nums[0], Math.max(nums[1], nums[2]));
		}
		else
		{
			int[] skip = new int[len];
			int[] take = new int[len];
			take[0] = nums[0];
			for (int i = 1; i < len - 1; i++)
			{
				take[i] = skip[i - 1] + nums[i];
				skip[i] = Math.max(skip[i - 1], take[i - 1]);
			}
			int max = Math.max(take[len - 2], skip[len - 2]);

			skip[1] = 0;
			take[1] = nums[1];
			for (int i = 2; i < len; i++)
			{
				take[i] = skip[i - 1] + nums[i];
				skip[i] = Math.max(skip[i - 1], take[i - 1]);
			}
			max = Math.max(max, Math.max(take[len - 1], skip[len - 1]));

			return max;
		}
	}
}
