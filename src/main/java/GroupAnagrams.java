import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(id = 49, name = "Group Anagrams", url = "https://leetcode.com/problems/group-anagrams/")
public class GroupAnagrams
{
	public List<List<String>> groupAnagrams(String[] strs)
	{
		List<List<String>> result = new ArrayList<>();
		if (strs == null || strs.length == 0)
		{
			return result;
		}

		Map<String, List<String>> cache = new HashMap<>();
		for (String str : strs)
		{
			if (str == null)
			{
				continue;
			}

			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String value = String.valueOf(chars);
			List<String> strings = cache.getOrDefault(value, new ArrayList<>());
			strings.add(str);
			cache.put(value, strings);
		}

		result.addAll(cache.values());

		return result;
	}
}
