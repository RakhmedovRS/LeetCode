package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/12/2021
 */
@LeetCode(
	id = 1930,
	name = "Unique Length-3 Palindromic Subsequences",
	url = "https://leetcode.com/problems/unique-length-3-palindromic-subsequences/",
	difficulty = Difficulty.MEDIUM
)
public class UniqueLength3PalindromicSubsequences
{
	public int countPalindromicSubsequence(String s)
	{
		int count = 0;
		for (char leftAndRight = 'a'; leftAndRight <= 'z'; leftAndRight++)
		{
			for (char middle = 'a'; middle <= 'z'; middle++)
			{
				int l = s.indexOf(leftAndRight);
				int r = s.lastIndexOf(leftAndRight);
				if (l != -1 && r != -1)
				{
					int m = s.indexOf(middle, l + 1);
					if (m != -1 && m < r)
					{
						count++;
					}
				}
			}
		}

		return count;
	}
}
