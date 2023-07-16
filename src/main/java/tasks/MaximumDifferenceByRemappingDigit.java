package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2/18/2023
 */
@LeetCode(
		id = 2566,
		name = "Maximum Difference by Remapping a Digit",
		url = "https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/",
		difficulty = Difficulty.EASY
)
public class MaximumDifferenceByRemappingDigit
{
	public int minMaxDifference(int num)
	{
		String nums = "" + num;
		int max = 0;
		for (int p = 0; p < nums.length(); p++)
		{
			max *= 10;
			if (nums.charAt(p) != '9')
			{
				max += 9;
				int mMap = nums.charAt(p) - '0';
				for (int i = p + 1; i < nums.length(); i++)
				{
					max *= 10;
					if (nums.charAt(i) - '0' == mMap)
					{
						max += 9;
					}
					else
					{
						max += nums.charAt(i) - '0';
					}
				}

				break;
			}
			else
			{
				max += nums.charAt(p) - '0';
			}
		}

		int min = 0;

		int mMap = nums.charAt(0) - '0';
		for (int i = 1; i < nums.length(); i++)
		{
			min *= 10;
			if (nums.charAt(i) - '0' == mMap)
			{
				min += 0;
			}
			else
			{
				min += nums.charAt(i) - '0';
			}
		}

		return max - min;
	}
}
