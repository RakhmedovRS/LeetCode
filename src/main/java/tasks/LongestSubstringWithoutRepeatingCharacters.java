package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(
	id = 3,
	name = "Longest Substring Without Repeating Characters",
	url = "https://leetcode.com/problems/longest-substring-without-repeating-characters/",
	difficulty = Difficulty.MEDIUM
)
public class LongestSubstringWithoutRepeatingCharacters
{
	public int lengthOfLongestSubstring(String s)
	{
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;
		int count;
		char ch;
		while (right < s.length())
		{
			ch = s.charAt(right);
			while (right < s.length())
			{
				ch = s.charAt(right++);
				max = Math.max(max, map.size());
				count = map.getOrDefault(ch, 0) + 1;
				map.put(ch, count);
				if (count > 1)
				{
					break;
				}
			}

			while (map.get(ch) > 1)
			{
				count = map.remove(s.charAt(left));
				if (count > 1)
				{
					map.put(s.charAt(left), count - 1);
				}
				left++;
			}

			max = Math.max(max, map.size());
		}

		return max;
	}

	public static void main(String[] args)
	{
		LongestSubstringWithoutRepeatingCharacters clazz = new LongestSubstringWithoutRepeatingCharacters();

		System.out.println(clazz.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(clazz.lengthOfLongestSubstring("bbbbb"));
		System.out.println(clazz.lengthOfLongestSubstring("pwwkew"));
	}
}
