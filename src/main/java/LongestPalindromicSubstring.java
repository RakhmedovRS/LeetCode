import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 5, name = "Longest Palindromic Substring", url = "https://leetcode.com/problems/longest-palindromic-substring/")
public class LongestPalindromicSubstring
{
	public String longestPalindrome(String s)
	{
		if (s == null || s.length() == 0)
		{
			return "";
		}

		char[] chars = s.toCharArray();
		int start = 0;
		int end = 0;
		int maxLength;
		for (int center = 0; center < s.length(); center++)
		{
			int odd = checkAroundTheCenter(chars, center, center);
			int even = checkAroundTheCenter(chars, center, center + 1);
			maxLength = Math.max(odd, even);
			if (maxLength > end - start)
			{
				start = center - (maxLength - 1) / 2;
				end = center + maxLength / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	private int checkAroundTheCenter(char[] chars, int left, int right)
	{
		while (left >= 0 && right < chars.length && chars[left] == chars[right])
		{
			left--;
			right++;
		}

		return right - left - 1;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("racecar"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("raceecar"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("xabay"));
	}
}
