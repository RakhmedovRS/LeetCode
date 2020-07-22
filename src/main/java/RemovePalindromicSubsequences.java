import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Jul-20
 */
@LeetCode(id = 1332, name = "Remove Palindromic Subsequences", url = "https://leetcode.com/problems/remove-palindromic-subsequences/")
public class RemovePalindromicSubsequences
{
	public int removePalindromeSub(String s)
	{
		if (s == null || s.isEmpty())
		{
			return 0;
		}

		if (s.equals(new StringBuilder(s).reverse().toString()))
		{
			return 1;
		}

		boolean containsA = false;
		boolean containsB = false;
		for (char ch : s.toCharArray())
		{
			if (ch == 'a')
			{
				containsA = true;
			}
			else
			{
				containsB = true;
			}

			if (containsA && containsB)
			{
				break;
			}
		}

		return (containsA ? 1 : 0) + (containsB ? 1 : 0);
	}
}
