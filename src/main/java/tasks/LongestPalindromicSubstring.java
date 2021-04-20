package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(
	id = 5,
	name = "Longest Palindromic Substring",
	url = "https://leetcode.com/problems/longest-palindromic-substring/",
	difficulty = Difficulty.MEDIUM
)
public class LongestPalindromicSubstring
{
	public String longestPalindrome(String s)
	{
		int left = 0;
		int right = 0;
		char[] chars = s.toCharArray();
		int max;
		for (int i = 0; i < s.length(); i++)
		{
			int a = longestPalindrome(i, i, chars);
			int b = longestPalindrome(i, i + 1, chars);
			max = Math.max(a, b);
			if (1 + right - left < max)
			{
				left = i - (max - 1) / 2;
				right = i + max / 2;
			}
		}

		return s.substring(left, right + 1);
	}

	private int longestPalindrome(int left, int right, char[] chars)
	{
		int max = 0;
		while (left >= 0 && right < chars.length)
		{
			if (chars[left] == chars[right])
			{
				max = Math.max(max, 1 + right - left);
				left--;
				right++;
			}
			else
			{
				break;
			}
		}
		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("racecar"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("raceecar"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("xabay"));
	}
}
