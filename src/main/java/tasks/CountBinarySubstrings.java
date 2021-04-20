package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Jul-20
 */
@LeetCode(id = 696, name = "Count Binary Substrings", url = "https://leetcode.com/problems/count-binary-substrings/")
public class CountBinarySubstrings
{
	public int countBinarySubstrings(String s)
	{
		int count = 0;
		int groups = 0;
		char prev = s.charAt(0);
		int prevCount = 0;
		for (char ch : s.toCharArray())
		{
			if (ch == prev)
			{
				count++;
			}
			else
			{
				groups += Math.min(count, prevCount);
				prev = ch;
				prevCount = count;
				count = 1;
			}
		}
		groups += Math.min(count, prevCount);

		return groups;
	}
}
