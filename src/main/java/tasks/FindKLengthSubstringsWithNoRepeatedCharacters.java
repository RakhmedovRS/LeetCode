package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/19/2020
 */
@LeetCode(
		id = 1100,
		name = "Find K-Length Substrings With No Repeated Characters",
		url = "https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FindKLengthSubstringsWithNoRepeatedCharacters
{
	public int numKLenSubstrNoRepeats(String S, int K)
	{
		int count = 0;
		int[] table = new int[26];
		int left = 0;
		int right = 0;
		char[] chars = S.toCharArray();

		while (right < chars.length)
		{
			table[chars[right++] - 'a']++;
			if (right - left >= K)
			{
				if (right - left > K)
				{
					table[chars[left++] - 'a']--;
				}
				count += isValid(table) ? 1 : 0;
			}
		}

		return count;
	}

	private boolean isValid(int[] table)
	{
		for (int c : table)
		{
			if (c > 1)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindKLengthSubstringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats("home", 5));
		System.out.println(new FindKLengthSubstringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats("havefunonleetcode", 5));
	}
}
