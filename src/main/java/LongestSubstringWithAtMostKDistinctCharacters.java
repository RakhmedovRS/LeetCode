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
		char[] chars = s.toCharArray();
		int max = 0;
		int left = 0;
		int right = 0;
		Map<Character, Integer> map = new HashMap<>();
		char ch;
		int count;
		while (right < chars.length)
		{
			while (right < chars.length && map.size() <= k)
			{
				max = Math.max(max, right - left);
				ch = chars[right++];
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}

			if (map.size() <= k)
			{
				max = Math.max(max, right - left);
			}

			while (left < right && map.size() > k)
			{
				ch = chars[left++];
				count = map.remove(ch) - 1;
				if (count > 0)
				{
					map.put(ch, count);
				}
			}
		}

		return max;
	}
}
