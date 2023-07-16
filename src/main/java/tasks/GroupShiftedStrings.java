package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/11/2021
 */
@LeetCode(
		id = 249,
		name = "Group Shifted Strings",
		url = "https://leetcode.com/problems/group-shifted-strings/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class GroupShiftedStrings
{
	public List<List<String>> groupStrings(String[] strings)
	{
		Map<String, List<String>> map = new HashMap<>();
		String key;
		for (String string : strings)
		{
			key = getKey(string);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(string);
		}

		return new ArrayList<>(map.values());
	}

	private String getKey(String string)
	{
		char[] chars = string.toCharArray();
		int shift = chars[0] - 'a';

		for (int i = 0; i < chars.length; i++)
		{
			chars[i] = (char) ((chars[i] - shift) % 26);
		}

		return String.valueOf(chars);
	}
}
