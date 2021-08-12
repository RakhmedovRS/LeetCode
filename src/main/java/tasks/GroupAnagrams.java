package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(
	id = 49,
	name = "Group Anagrams",
	url = "https://leetcode.com/problems/group-anagrams/",
	difficulty = Difficulty.MEDIUM
)
public class GroupAnagrams
{
	public List<List<String>> groupAnagrams(String[] strs)
	{
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs)
		{
			String sorted = sort(str);
			map.putIfAbsent(sorted, new ArrayList<>());
			map.get(sorted).add(str);
		}

		return new ArrayList<>(map.values());
	}

	private String sort(String str)
	{
		int[] memo = new int[26];
		for (char ch : str.toCharArray())
		{
			memo[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < memo.length; i++)
		{
			while (memo[i]-- != 0)
			{
				sb.append((char) (i + 'a'));
			}
		}

		return sb.toString();
	}
}
