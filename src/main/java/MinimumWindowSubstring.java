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
	private boolean checkSatisfy(Map<Character, Integer> example, Map<Character, Integer> window)
	{
		for (Map.Entry<Character, Integer> entry : example.entrySet())
		{
			Integer val = window.get(entry.getKey());
			if (val == null || val < entry.getValue())
			{
				return false;
			}
		}
		return true;
	}

	public String minWindow(String s, String t)
	{
		int[] ans = new int[]{Integer.MAX_VALUE, 0, 0};
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length())
		{
			return "";
		}

		Map<Character, Integer> example = new HashMap<>();
		for (char ch : t.toCharArray())
		{
			example.put(ch, example.getOrDefault(ch, 0) + 1);
		}

		Map<Character, Integer> window = new HashMap<>();
		int left = 0;
		int right = -1;
		while (right < s.length())
		{
			if (checkSatisfy(example, window))
			{
				if (ans[0] == Integer.MAX_VALUE || (right - left + 1) < ans[0])
				{
					ans[0] = (right - left + 1);
					ans[1] = left;
					ans[2] = right + 1;
				}

				Integer count = window.get(s.charAt(left));
				if (count == 1)
				{
					window.remove(s.charAt(left));
				}
				else
				{
					window.computeIfPresent(s.charAt(left), (ch, val) -> --val);
				}
				left++;
			}
			else
			{
				right++;
				if (right < s.length())
				{
					window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
				}
			}
		}

		return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2]);
	}
}
