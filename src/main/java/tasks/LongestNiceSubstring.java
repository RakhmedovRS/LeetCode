package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/20/2021
 */
@LeetCode(
	id = 1763,
	name = "Longest Nice Substring",
	url = "https://leetcode.com/problems/longest-nice-substring/",
	difficulty = Difficulty.EASY
)
public class LongestNiceSubstring
{
	public String longestNiceSubstring(String s)
	{
		char[] chars = s.toCharArray();
		String max = "";
		for (int i = 0; i < chars.length; i++)
		{
			boolean[] lower = new boolean[26];
			boolean[] upper = new boolean[26];
			for (int j = i; j < chars.length; j++)
			{
				if (Character.isUpperCase(chars[j]))
				{
					upper[chars[j] - 'A'] = true;
				}
				else
				{
					lower[chars[j] - 'a'] = true;
				}

				boolean valid = true;
				for (int y = 0; y < 26; y++)
				{
					if (lower[y] != upper[y])
					{
						valid = false;
						break;
					}
				}

				if (valid && 1 + j - i > max.length())
				{
					max = s.substring(i, j + 1);
				}
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		LongestNiceSubstring clazz = new LongestNiceSubstring();
		System.out.println(clazz.longestNiceSubstring("dDzeE"));
		System.out.println(clazz.longestNiceSubstring("c"));
		System.out.println(clazz.longestNiceSubstring("Bb"));
		System.out.println(clazz.longestNiceSubstring("YazaAay"));
	}
}
