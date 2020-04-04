import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 3, name = "Longest Substring Without Repeating Characters", url = "https://leetcode.com/problems/longest-substring-without-repeating-characters/")
public class LongestSubstringWithoutRepeatingCharacters
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}

		char[] chars = s.toCharArray();
		int max = 0;
		Set<Character> set = new HashSet<>();
		int end = 0;
		for (int start = 0; start < chars.length; start++)
		{
			while (end < chars.length && set.add(chars[end]))
			{
				end++;
				max = Math.max(max, set.size());
			}

			set.remove(chars[start]);
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
	}
}
