import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(id = 409, name = "Longest Palindrome", url = "https://leetcode.com/problems/longest-palindrome/")
public class LongestPalindrome
{
	public int longestPalindrome(String s)
	{
		int[] map = new int[256];
		int total = 0;
		for (char ch : s.toCharArray())
		{
			map[ch]++;
			if (map[ch] == 2)
			{
				map[ch] = 0;
				total+=2;
			}
		}

		int max = 0;
		for (int count : map)
		{
			max = Math.max(max, count);
		}

		return total + max;
	}
}
