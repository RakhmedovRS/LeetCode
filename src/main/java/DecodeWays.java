import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(id = 91, name = "Decode Ways", url = "https://leetcode.com/problems/decode-ways/")
public class DecodeWays
{
	public int numDecodings(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}

		Set<String> dictionary = new HashSet<>();
		for (int i = 1; i <= 26; i++)
		{
			dictionary.add(String.valueOf(i));
		}
		Map<Integer, Integer> cache = new HashMap<>();
		int res = numDecodings(s, 0, dictionary, cache);
		return res == -1 ? 0 : res;
	}

	private int numDecodings(String s, int pos, Set<String> dictionary, Map<Integer, Integer> cache)
	{
		int result = 0;
		if (pos >= s.length())
		{
			return 1;
		}

		if (cache.containsKey(pos))
		{
			return cache.get(pos);
		}

		String one = s.substring(pos, pos + 1);
		if ("0".equals(one))
		{
			return -1;
		}
		String two = pos == s.length() - 1 ? "" : s.substring(pos, pos + 2);

		int next;
		if (dictionary.contains(one))
		{
			next = numDecodings(s, pos + 1, dictionary, cache);
			if (next != -1)
			{
				result += next;
			}
		}

		if (dictionary.contains(two))
		{
			next = numDecodings(s, pos + 2, dictionary, cache);
			if (next != -1)
			{
				result += next;
			}
		}

		cache.put(pos, result);
		return result;
	}
}
