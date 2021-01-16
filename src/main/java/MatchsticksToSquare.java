import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/16/2021
 */
@LeetCode(
	id = 473,
	name = "Matchsticks to Square",
	url = "https://leetcode.com/problems/matchsticks-to-square/",
	difficulty = Difficulty.MEDIUM
)
public class MatchsticksToSquare
{
	public boolean makesquare(int[] nums)
	{
		if(nums.length == 0)
		{
			return false;
		}

		int sum = 0;
		for (int num : nums)
		{
			sum += num;
		}

		if (sum % 4 != 0)
		{
			return false;
		}

		Arrays.sort(nums);

		int target = sum / 4;
		boolean[] used = new boolean[nums.length];
		if (canCreateSquare(nums, target, used)
			&& canCreateSquare(nums, target, used)
			&& canCreateSquare(nums, target, used)
			&& canCreateSquare(nums, target, used)
		)
		{
			for (boolean u : used)
			{
				if (!u)
				{
					return false;
				}
			}

			return true;
		}

		return false;
	}

	private boolean canCreateSquare(int[] nums, int sum, boolean[] used)
	{
		if (sum == 0)
		{
			return true;
		}

		for (int i = nums.length - 1; i >= 0; i--)
		{
			if (!used[i] && sum - nums[i] >= 0)
			{
				used[i] = true;
				if (canCreateSquare(nums, sum - nums[i], used))
				{
					return true;
				}
				used[i] = false;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		MatchsticksToSquare clazz = new MatchsticksToSquare();
		System.out.println(clazz.makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
	}
}
