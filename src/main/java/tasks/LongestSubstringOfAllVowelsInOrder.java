package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/25/2021
 */
@LeetCode(
	id = 1839,
	name = "Longest Substring Of All Vowels in Order",
	url = "https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/",
	difficulty = Difficulty.MEDIUM
)
public class LongestSubstringOfAllVowelsInOrder
{
	public int longestBeautifulSubstring(String word)
	{
		int max = 0;
		int left = 0;
		int right = 0;

		char[] chars = word.toCharArray();
		while (left < chars.length)
		{
			if (chars[left] != 'a')
			{
				left++;
				continue;
			}

			right = left + 1;

			boolean seenE = false;
			boolean seenI = false;
			boolean seenO = false;
			boolean seenU = false;
			while (right < chars.length && isVowel(chars[right]) && chars[right - 1] <= chars[right])
			{
				if (chars[right] == 'e')
				{
					seenE = true;
				}
				else if (chars[right] == 'i')
				{
					seenI = true;
				}
				else if (chars[right] == 'o')
				{
					seenO = true;
				}
				else if (chars[right] == 'u')
				{
					seenU = true;
				}

				if (seenE && seenI && seenO && seenU)
				{
					max = Math.max(max, 1 + right - left);
				}

				right++;
			}

			left = right;
		}

		return max;
	}

	private boolean isVowel(char ch)
	{
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
