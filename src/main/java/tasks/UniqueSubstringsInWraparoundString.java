package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(id = 467, name = "Unique Substrings in Wraparound String", url = "https://leetcode.com/problems/unique-substrings-in-wraparound-string/")
public class UniqueSubstringsInWraparoundString
{
	public int findSubstringInWraproundString(String p)
	{
		int[] maximums = new int[26];
		int max = 1;
		char[] chars = p.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (i > 0)
			{
				if (chars[i] - chars[i - 1] == 1 || chars[i - 1] - chars[i] == 25)
				{
					max++;
				}
				else
				{
					max = 1;
				}
			}

			maximums[chars[i] - 'a'] = Math.max(maximums[chars[i] - 'a'], max);
		}

		return Arrays.stream(maximums).sum();
	}
}
