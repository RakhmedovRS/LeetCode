import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/17/2021
 */
@LeetCode(
	id = 1827,
	name = "Minimum Operations to Make the Array Increasing",
	url = "https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/",
	difficulty = Difficulty.EASY
)
public class MinimumOperationsToMakeTheArrayIncreasing
{
	public int minOperations(int[] nums)
	{
		int adds = 0;
		int num = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			if (num > nums[i])
			{
				adds += 1 + num - nums[i];
				num++;
			}
			else if (num == nums[i])
			{
				adds++;
				num++;
			}
			else
			{
				num = nums[i];
			}
		}

		return adds;
	}
}
