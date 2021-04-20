package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
	id = 1180,
	name = "Count Substrings with Only One Distinct Letter",
	url = "https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class CountSubstringsWithOnlyOneDistinctLetter
{
	public int countLetters(String S)
	{
		int totalCount = 0;
		int count = 0;
		char prev = ' ';
		for (char ch : S.toCharArray())
		{
			if (ch == prev)
			{
				count++;
			}
			else
			{
				totalCount += (count * (count + 1)) / 2;
				prev = ch;
				count = 1;
			}
		}

		if (S.charAt(S.length() - 1) == prev)
		{
			totalCount += (count * (count + 1)) / 2;
		}

		return totalCount;
	}

	public static void main(String[] args)
	{
		System.out.println(new CountSubstringsWithOnlyOneDistinctLetter().countLetters("aaaba"));
		System.out.println(new CountSubstringsWithOnlyOneDistinctLetter().countLetters("aaaaaaaaaa"));
	}
}
