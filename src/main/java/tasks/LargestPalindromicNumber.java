package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/30/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2384,
		name = "Largest Palindromic Number",
		url = "https://leetcode.com/problems/largest-palindromic-number/",
		difficulty = Difficulty.MEDIUM
)
public class LargestPalindromicNumber
{
	public String largestPalindromic(String num)
	{
		int[] count = new int[10];
		for (char ch : num.toCharArray())
		{
			count[ch - '0']++;
		}

		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();

		boolean hasTwo = true;
		while (hasTwo)
		{
			hasTwo = false;
			for (int i = 9; i >= 0; i--)
			{
				while (count[i] > 1 && !(i == 0 && left.length() == 0))
				{
					hasTwo = true;
					left.append(i);
					right.append(i);
					count[i] -= 2;
				}
			}
		}

		for (int i = 9; i >= 0; i--)
		{
			if (count[i] > 0)
			{
				return left.toString() + i + right.reverse();
			}
		}

		return left.toString() + right.reverse();
	}
}
