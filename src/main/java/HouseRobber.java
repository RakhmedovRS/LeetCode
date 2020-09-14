import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(id = 198, name = "House Robber", url = "https://leetcode.com/problems/house-robber/")
public class HouseRobber
{
	public int rob(int[] nums)
	{
		if (nums.length == 0)
		{
			return 0;
		}
		else if (nums.length == 1)
		{
			return nums[0];
		}

		int max = Math.max(nums[0], nums[1]);
		int[] memo = new int[nums.length];
		memo[0] = nums[0];
		memo[1] = nums[1];
		for (int i = 2; i < nums.length; i++)
		{
			for (int j = 0; j < i - 1; j++)
			{
				memo[i] = Math.max(memo[i], memo[j] + nums[i]);
				max = Math.max(max, memo[i]);
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
		System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
		System.out.println(new HouseRobber().rob(new int[]{2, 1, 1, 2}));
	}
}
