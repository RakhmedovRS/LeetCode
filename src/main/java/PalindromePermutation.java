import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/15/2020
 */
@LeetCode(
	id = 266,
	name = "Palindrome Permutation",
	url = "https://leetcode.com/problems/palindrome-permutation/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class PalindromePermutation
{
	public boolean canPermutePalindrome(String s)
	{
		int[] table = new int[Character.MAX_VALUE];
		for (char ch : s.toCharArray())
		{
			table[ch]++;
		}

		boolean unpaired = false;
		for (int c : table)
		{
			if (c % 2 != 0)
			{
				if (unpaired)
				{
					return false;
				}
				unpaired = true;
			}
		}

		return true;
	}
}
