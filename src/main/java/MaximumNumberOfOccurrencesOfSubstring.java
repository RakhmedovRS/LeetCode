import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/7/2021
 */
@LeetCode(
	id = 1297,
	name = "Maximum Number of Occurrences of a Substring",
	url = "https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfOccurrencesOfSubstring
{
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize)
	{
		String sub;
		int count;
		int[] table;
		int maxFreq = 0;
		Map<String, Integer> subToCount;
		char[] chars = s.toCharArray();
		for (int size = minSize; size <= maxSize; size++)
		{
			table = new int[26];
			subToCount = new HashMap<>();
			if (size > chars.length)
			{
				break;
			}

			int left = 0;
			int right = 0;
			while (right < chars.length)
			{
				table[chars[right] - 'a']++;
				if (right - left >= size - 1)
				{
					if (right - left > size - 1)
					{
						table[chars[left++] - 'a']--;
					}

					if (isValidSub(table, maxLetters))
					{
						sub = s.substring(left, right + 1);
						count = subToCount.getOrDefault(sub, 0) + 1;
						maxFreq = Math.max(maxFreq, count);
						subToCount.put(sub, count);
					}
				}
				right++;
			}
		}

		return maxFreq;
	}

	private boolean isValidSub(int[] table, int maxLetters)
	{
		for (int c : table)
		{
			if (c != 0)
			{
				maxLetters--;
			}
		}
		return maxLetters >= 0;
	}

	public static void main(String[] args)
	{
		MaximumNumberOfOccurrencesOfSubstring clazz = new MaximumNumberOfOccurrencesOfSubstring();
		System.out.println(clazz.maxFreq("abcde", 2, 3, 3));
		System.out.println(clazz.maxFreq("aabcabcab", 2, 2, 3));
		System.out.println(clazz.maxFreq("aaaa", 1, 3, 3));
		System.out.println(clazz.maxFreq("aababcaab", 2, 3, 4));
	}
}
