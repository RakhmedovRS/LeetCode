package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Aug-20
 */
@LeetCode(
		id = 1558,
		name = "Minimum Numbers of Function Calls to Make Target Array",
		url = "https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumbersOfFunctionCallsToMakeTargetArray
{
	public int minOperations(int[] nums)
	{
		boolean zeroOuted = false;
		int steps = 0;
		while (!zeroOuted)
		{
			zeroOuted = true;
			for (int i = 0; i < nums.length; i++)
			{
				if (nums[i] % 2 != 0)
				{
					steps++;
					nums[i]--;
					if (zeroOuted)
					{
						zeroOuted = nums[i] == 0;
					}
				}
				else if (nums[i] != 0)
				{
					zeroOuted = false;
				}
			}

			if (!zeroOuted)
			{
				steps++;
				for (int i = 0; i < nums.length; i++)
				{
					nums[i] /= 2;
				}
			}
		}

		return steps;
	}
}
