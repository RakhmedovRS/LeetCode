import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/9/2020
 */
@LeetCode(id = 1392, name = "Longest Happy Prefix", url = "https://leetcode.com/problems/longest-happy-prefix/")
public class LongestHappyPrefix
{
	public String longestPrefix(String s)
	{
		char[] chars = s.toCharArray();
		int[] kmpTable = new int[s.length()];
		int left = 0;
		for (int right = 1; right < s.length(); )
		{
			if (chars[left] == chars[right])
			{
				kmpTable[right++] = ++left;
			}
			else if (left == 0)
			{
				right++;
			}
			else
			{
				left = kmpTable[left - 1];
			}
		}

		return s.substring(0, kmpTable[s.length() - 1]);
	}
}
