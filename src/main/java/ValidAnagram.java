import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 13-Mar-20
 */
@LeetCode(id = 242, name = "Valid Anagram", url = "https://leetcode.com/problems/valid-anagram/")
public class ValidAnagram
{
	public boolean isAnagram(String s, String t)
	{
		if (s == null || t == null || s.length() != t.length())
		{
			return false;
		}

		Map<Character, Integer> sCache = new HashMap<>();
		for (Character ch : s.toCharArray())
		{
			sCache.put(ch, sCache.getOrDefault(ch, 0) + 1);
		}

		Map<Character, Integer> tCache = new HashMap<>();
		for (Character ch : t.toCharArray())
		{
			tCache.put(ch, tCache.getOrDefault(ch, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : sCache.entrySet())
		{
			if (!entry.getValue().equals(tCache.get(entry.getKey())))
			{
				return false;
			}
		}
		return true;
	}
}
