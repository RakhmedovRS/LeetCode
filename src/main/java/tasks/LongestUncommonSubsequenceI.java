package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Jul-20
 */
@LeetCode(id = 521, name = "Longest Uncommon Subsequence I", url = "https://leetcode.com/problems/longest-uncommon-subsequence-i/")
public class LongestUncommonSubsequenceI
{
	public int findLUSlength(String a, String b)
	{
		if (a.equals(b))
		{
			return -1;
		}

		return Math.max(a.length(), b.length());
	}
}
