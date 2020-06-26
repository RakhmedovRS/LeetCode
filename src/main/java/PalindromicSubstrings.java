import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(id = 647, name = "Palindromic Substrings", url = "https://leetcode.com/problems/palindromic-substrings/")
public class PalindromicSubstrings
{
	public int countSubstrings(String s)
	{
		if (s == null || s.isEmpty())
		{
			return 0;
		}

		int[] palindromes = new int[]{0};
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			countPalindrome(chars, i, i, palindromes);
			countPalindrome(chars, i, i + 1, palindromes);
		}

		return palindromes[0];
	}

	private void countPalindrome(char[] chars, int left, int right, int[] palindromes)
	{
		while (left >= 0 && right < chars.length && chars[left] == chars[right])
		{
			palindromes[0]++;
			left--;
			right++;
		}
	}
}
