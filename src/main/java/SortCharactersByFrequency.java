import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
@LeetCode(id = 451, name = "Sort Characters By Frequency", url = "https://leetcode.com/problems/sort-characters-by-frequency/")
public class SortCharactersByFrequency
{
	public String frequencySort(String s)
	{
		Map<Character, Integer> cache = new HashMap<>();
		for (Character ch : s.toCharArray())
		{
			cache.put(ch, cache.getOrDefault(ch, 0) + 1);
		}

		List<Map.Entry<Integer, Character>> secondCache = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : cache.entrySet())
		{
			secondCache.add(new java.util.AbstractMap.SimpleEntry<>(entry.getValue(), entry.getKey()));
		}

		secondCache.sort((val1, val2) -> val2.getKey().compareTo(val1.getKey()));

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Character> entry : secondCache)
		{
			for (int i = 0; i < entry.getKey(); i++)
			{
				sb.append(entry.getValue());
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
	}
}
