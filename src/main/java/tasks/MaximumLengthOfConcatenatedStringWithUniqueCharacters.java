package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(
		id = 1239,
		name = "Maximum Length of a Concatenated String with Unique Characters",
		url = "https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters
{
	public int maxLength(List<String> arr)
	{
		int[] max = new int[]{0};

		List<String> validValues = new ArrayList<>();
		Map<String, int[]> stringMap = new HashMap<>();
		for (String s : arr)
		{
			int[] map = buildArr(s, stringMap);
			if (map != null && isUnique(map))
			{
				validValues.add(s);
				max[0] = Math.max(max[0], s.length());
			}
		}

		isPossibleToBuildUniqueString("", validValues, stringMap, 0, max);

		return max[0];
	}

	private boolean isPossibleToBuildUniqueString(String current, List<String> validValues,
												  Map<String, int[]> stringMap, int pos, int[] max)
	{
		if (pos == validValues.size())
		{
			return true;
		}

		String added;
		for (int i = pos; i < validValues.size(); i++)
		{
			added = current + validValues.get(i);
			int[] map = buildArr(added, stringMap);
			if (map != null && isUnique(map))
			{
				max[0] = Math.max(max[0], added.length());
				isPossibleToBuildUniqueString(added, validValues, stringMap, i + 1, max);
			}
		}

		return false;
	}

	private int[] buildArr(String val, Map<String, int[]> stringMap)
	{
		if (stringMap.containsKey(val))
		{
			return stringMap.get(val);
		}

		int[] map = new int[26];
		for (char ch : val.toCharArray())
		{
			map[ch - 'a']++;
			if (map[ch - 'a'] > 1)
			{
				map = null;
				break;
			}
		}

		stringMap.put(val, map);
		return map;
	}

	private boolean isUnique(int[] map)
	{
		for (int i = 0; i < 26; i++)
		{
			if (map[i] > 1)
			{
				return false;
			}
		}

		return true;
	}
}
