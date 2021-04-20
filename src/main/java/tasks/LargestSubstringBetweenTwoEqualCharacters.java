package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/18/2020
 */
@LeetCode(id = 1624, name = "Largest Substring Between Two Equal Characters", url = "https://leetcode.com/problems/largest-substring-between-two-equal-characters/")
public class LargestSubstringBetweenTwoEqualCharacters
{
	public int maxLengthBetweenEqualCharacters(String s)
	{
		int[][] charPositions = new int[26][2];
		for (int[] pos : charPositions)
		{
			pos[0] = Integer.MAX_VALUE;
			pos[1] = Integer.MIN_VALUE;
		}

		char ch;
		for (int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			if (charPositions[ch - 'a'][0] == Integer.MAX_VALUE)
			{
				charPositions[ch - 'a'][0] = i;
			}
			else
			{
				charPositions[ch - 'a'][1] = i;
			}
		}

		int max = -1;
		for (int[] pos : charPositions)
		{
			if (pos[0] != Integer.MAX_VALUE && pos[1] != Integer.MIN_VALUE)
			{
				max = Math.max(max, pos[1] - pos[0] - 1);
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("aa"));
		System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("abca"));
		System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("cbzxy"));
		System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("cabbac"));
	}
}
