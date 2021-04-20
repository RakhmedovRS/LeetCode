package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Sep-20
 */
@LeetCode(id = 1542, name = "Find Longest Awesome Substring", url = "https://leetcode.com/problems/find-longest-awesome-substring/")
public class FindLongestAwesomeSubstring
{
	public int longestAwesome(String s)
	{
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int res = 0;
		int mask = 0;
		for (int i = 0; i < s.length(); i++)
		{
			mask = mask ^ (1 << (s.charAt(i) - '0'));
			map.putIfAbsent(mask, i);
			res = Math.max(res, i - map.get(mask));
			int temp;
			for (int j = 0; j <= 9; j++)
			{
				temp = mask ^ (1 << j);
				if (map.containsKey(temp))
				{
					res = Math.max(res, i - map.get(temp));
				}
			}
		}
		return res;
	}
}
