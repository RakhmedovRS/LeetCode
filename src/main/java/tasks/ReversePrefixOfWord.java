package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/12/2021
 */
@LeetCode(
	id = 2000,
	name = "Reverse Prefix of Word",
	url = "https://leetcode.com/problems/reverse-prefix-of-word/",
	difficulty = Difficulty.EASY
)
public class ReversePrefixOfWord
{
	public String reversePrefix(String word, char ch)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++)
		{
			sb.append(word.charAt(i));
			if (word.charAt(i) == ch)
			{
				return sb.reverse() + word.substring(i + 1);
			}
		}

		return word;
	}
}
