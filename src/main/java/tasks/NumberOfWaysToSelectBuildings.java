package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/20/2022
 */
@LeetCode(
		id = 2222,
		name = "Number of Ways to Select Buildings",
		url = "https://leetcode.com/problems/number-of-ways-to-select-buildings/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfWaysToSelectBuildings
{
	public long numberOfWays(String s)
	{
		int[] zeroLeftToRight = new int[s.length()];
		int[] zeroRightToLeft = new int[s.length()];
		int[] oneLeftToRight = new int[s.length()];
		int[] oneRightToLeft = new int[s.length()];

		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == '0')
			{
				zeroLeftToRight[i] += 1 + ((i > 0) ? zeroLeftToRight[i - 1] : 0);
				oneLeftToRight[i] += ((i > 0) ? oneLeftToRight[i - 1] : 0);
			}
			else
			{
				zeroLeftToRight[i] += ((i > 0) ? zeroLeftToRight[i - 1] : 0);
				oneLeftToRight[i] += 1 + ((i > 0) ? oneLeftToRight[i - 1] : 0);
			}
		}

		for (int i = chars.length - 1; i >= 0; i--)
		{
			if (chars[i] == '0')
			{
				zeroRightToLeft[i] += 1 + ((i < chars.length - 1) ? zeroRightToLeft[i + 1] : 0);
				oneRightToLeft[i] += ((i < chars.length - 1) ? oneRightToLeft[i + 1] : 0);
			}
			else
			{
				zeroRightToLeft[i] += ((i < chars.length - 1) ? zeroRightToLeft[i + 1] : 0);
				oneRightToLeft[i] += 1 + ((i < chars.length - 1) ? oneRightToLeft[i + 1] : 0);
			}
		}

		long result = 0;
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == '0')
			{
				result += oneLeftToRight[i] * oneRightToLeft[i];
			}
			else
			{
				result += zeroLeftToRight[i] * zeroRightToLeft[i];
			}
		}

		return result;
	}
}
