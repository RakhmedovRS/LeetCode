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
		int[] table = new int[Character.MAX_VALUE + 1];
		for (char ch : s.toCharArray())
		{
			table[ch]++;
		}

		return canPermutePalindrome(table);
	}

	private boolean canPermutePalindrome(int[] table)
	{
		boolean seenOdd = false;
		for (int count : table)
		{
			if (count % 2 == 1)
			{
				if (seenOdd)
				{
					return false;
				}

				seenOdd = true;
			}
		}

		return true;
	}
}
