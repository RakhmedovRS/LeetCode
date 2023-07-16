package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(
		id = 1540,
		name = "Can Convert String in K Moves",
		url = "https://leetcode.com/problems/can-convert-string-in-k-moves/",
		difficulty = Difficulty.MEDIUM
)
public class CanConvertStringInKMoves
{
	public boolean canConvertString(String s, String t, int k)
	{
		if (s.length() != t.length())
		{
			return false;
		}

		int[] memo = new int[26];
		int diff;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) != t.charAt(i))
			{
				if (s.charAt(i) > t.charAt(i))
				{
					diff = 26 - (s.charAt(i) - 'a') + (t.charAt(i) - 'a');
				}
				else
				{
					diff = t.charAt(i) - s.charAt(i);
				}

				memo[diff]++;
				if (diff + (memo[diff] - 1) * 26 > k)
				{
					return false;
				}
			}
		}

		return true;
	}
}
