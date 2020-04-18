import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@LeetCode(id = 76, name = "Minimum Window Substring", url = "https://leetcode.com/problems/minimum-window-substring/")
public class MinimumWindowSubstring
{
	public String minWindow(String string, String pattern)
	{
		if (string == null || string.length() == 0 || pattern == null || pattern.length() == 0 || string.length() < pattern.length())
		{
			return "";
		}

		Map<Character, Integer> window = new HashMap<>();
		for (char ch : pattern.toCharArray())
		{
			window.put(ch, window.getOrDefault(ch, 0) - 1);
		}
		int left = 0;
		int right = -1;
		int leftMin = 0;
		int rightMin = string.length();
		boolean found = false;
		while (right < string.length())
		{
			if (!isMatches(window))
			{
				right++;
				if (right < string.length())
				{
					char rightChar = string.charAt(right);
					if (window.containsKey(rightChar))
					{
						window.put(rightChar, window.get(rightChar) + 1);
					}
				}
			}
			else
			{
				found = true;
				if (rightMin - leftMin > right - left + 1)
				{
					leftMin = left;
					rightMin = right + 1;
				}
				char leftChar = string.charAt(left++);
				if (window.containsKey(leftChar))
				{
					window.put(leftChar, window.get(leftChar) - 1);
				}
			}
		}

		return found ? string.substring(leftMin, rightMin) : "";
	}

	private boolean isMatches(Map<Character, Integer> window)
	{
		for (int val : window.values())
		{
			if (val < 0)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumWindowSubstring().minWindow("ab", "a"));
		System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
	}
}
