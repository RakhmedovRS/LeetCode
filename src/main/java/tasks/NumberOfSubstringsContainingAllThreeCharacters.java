package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/7/2020
 */
@LeetCode(id = 1358, name = "Number of Substrings Containing All Three Characters", url = "https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/")
public class NumberOfSubstringsContainingAllThreeCharacters
{
	public int numberOfSubstrings(String s)
	{
		int count = 0;
		int[] memo = new int[3];
		int left = 0;
		for (int right = 0; right < s.length(); right++)
		{
			memo[s.charAt(right) - 'a']++;
			while (memo[0] > 0 && memo[1] > 0 && memo[2] > 0)
			{
				count += s.length() - right;
				memo[s.charAt(left++) - 'a']--;
			}
		}

		return count;
	}
}
