/**
 * House Robber
 * LeetCode 198
 *
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
public class HouseRobber
{
	public int rob(int[] nums)
	{
		if (nums.length == 0)
		{
			return 0;
		}

		int[] memo = new int[nums.length + 1];

		memo[0] = 0;
		memo[1] = nums[0];
		int max = 0;

		for (int i = 1; i < nums.length; i++)
		{
			memo[i + 1] = Math.max(memo[i], memo[i - 1] + nums[i]);
		}

		return memo[nums.length];
	}

	public static void main(String[] args)
	{
		System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
		System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
		System.out.println(new HouseRobber().rob(new int[]{2, 1, 1, 2}));
	}
}
