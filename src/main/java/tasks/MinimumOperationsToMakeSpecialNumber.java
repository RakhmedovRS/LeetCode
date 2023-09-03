package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 9/3/2023
 */
@LeetCode(
		id = 2844,
		name = "Minimum Operations to Make a Special Number",
		url = "https://leetcode.com/problems/minimum-operations-to-make-a-special-number/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeSpecialNumber
{
	public int minimumOperations(String num)
	{
		if ("0".equals(num))
		{
			return 0;
		}

		int min = Integer.MAX_VALUE;
		char[] chars = num.toCharArray();
		boolean containsZero = false;
		for (String s : Arrays.asList("00", "25", "50", "75"))
		{
			for (int i = chars.length - 1; i > 0; i--)
			{
				if (chars[i] == '0')
				{
					containsZero = true;
				}
				for (int j = i - 1; j >= 0; j--)
				{
					if (chars[j] == '0')
					{
						containsZero = true;
					}
					if (s.equals("" + chars[j] + chars[i]))
					{
						min = Math.min(min, chars.length - j - 2);
					}
				}
			}
		}

		if (min == Integer.MAX_VALUE)
		{
			if (containsZero)
			{
				return num.length() - 1;
			}
			return num.length();
		}

		return min;
	}
}
