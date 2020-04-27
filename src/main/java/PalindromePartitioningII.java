import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 27-Apr-20
 */
@LeetCode(id = 132, name = "Palindrome Partitioning II", url = "https://leetcode.com/problems/palindrome-partitioning-ii/")
public class PalindromePartitioningII
{
	public int minCut(String s)
	{
		return dfs(s, new HashMap<>());
	}

	private int dfs(String s, Map<String, Integer> map)
	{
		if (map.containsKey(s))
		{
			return map.get(s);
		}

		if (s.length() <= 1 || isPalindrome(s))
		{
			return 0;
		}

		int res = s.length();
		for (int i = 1; i < s.length(); i++)
		{
			String sub = s.substring(0, i);
			if (isPalindrome(sub))
			{
				res = Math.min(res, dfs(s.substring(i), map) + 1);
			}
		}
		map.put(s, res);
		return res;
	}

	private boolean isPalindrome(String string)
	{
		int start = 0;
		int end = string.length() - 1;


		while (start < end)
		{
			if (string.charAt(start) != string.charAt(end))
			{
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
}
