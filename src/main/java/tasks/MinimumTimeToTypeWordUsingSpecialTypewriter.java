package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/22/2021
 */
@LeetCode(
	id = 1974,
	name = "Minimum Time to Type Word Using Special Typewriter",
	url = "https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/",
	difficulty = Difficulty.EASY
)
public class MinimumTimeToTypeWordUsingSpecialTypewriter
{
	public int minTimeToType(String word)
	{
		int time = 0;

		int pos = 0;
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (char ch : word.toCharArray())
		{
			time++;
			int left = 0;
			int right = 0;

			int l = pos;
			while (chars[l] != ch)
			{
				l--;
				if (l < 0)
				{
					l = chars.length - 1;
				}
				left++;
			}

			int r = pos;
			while (chars[r] != ch)
			{
				r++;
				if (r == chars.length)
				{
					r = 0;
				}
				right++;
			}

			time += Math.min(left, right);
			pos = ch - 'a';
		}

		return time;
	}
}
