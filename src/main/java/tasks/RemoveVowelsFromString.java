package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/11/2020
 */
@LeetCode(
	id = 1119,
	name = "Remove Vowels from a String",
	url = "https://leetcode.com/problems/remove-vowels-from-a-string/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class RemoveVowelsFromString
{
	public String removeVowels(String S)
	{
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < S.length(); i++)
		{
			ch = S.charAt(i);
			if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
			{
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
