package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/8/2020
 */
@LeetCode(
	id = 340,
	name = "Longest Substring with At Most K Distinct Characters",
	url = "https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class LongestSubstringWithAtMostKDistinctCharacters
{
	public int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		int max = 0;
		int left = 0;
		int right = 0;
		Map<Character, Integer> map = new HashMap<>();
		char ch;
		int count;
		while (right < s.length())
		{
			while (right < s.length() && map.size() <= k)
			{
				max = Math.max(max, right - left);
				ch = s.charAt(right++);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}

			while (map.size() > k)
			{
				ch = s.charAt(left++);
				count = map.get(ch) - 1;
				if (count == 0)
				{
					map.remove(ch);
				}
				else
				{
					map.put(ch, count);
				}
			}

			max = Math.max(max, right - left);
		}

		return max;
	}
}
