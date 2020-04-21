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
	public int numDecodings(String string)
	{
		if (string == null || string.length() == 0)
		{
			return 0;
		}
		Set<String> set = new HashSet<>();
		for (int i = 1; i <= 26; i++)
		{
			set.add(String.valueOf(i));
		}
		Map<Integer, Integer> cache = new HashMap<>();

		return numDecodings(string, 0, set, cache);
	}

	private int numDecodings(String string, int startPos, Set<String> set, Map<Integer, Integer> cache)
	{
		if (startPos >= string.length())
		{
			return 1;
		}

		Integer answer = cache.get(startPos);
		if (answer != null)
		{
			return answer;
		}

		answer = 0;
		if (set.contains(string.substring(startPos, startPos + 1)))
		{
			answer += numDecodings(string, startPos + 1, set, cache);
		}

		if (startPos + 2 <= string.length() && set.contains(string.substring(startPos, startPos + 2)))
		{
			answer += numDecodings(string, startPos + 2, set, cache);
		}

		cache.put(startPos, answer);
		return answer;
	}
}
