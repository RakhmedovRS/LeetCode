import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 387, name = "First Unique Character in a String", url = "https://leetcode.com/problems/first-unique-character-in-a-string/")
public class FirstUniqueCharacterInString
{
	public int firstUniqChar(String s)
	{
		char[] values = s.toCharArray();
		Map<Character, Integer> cache = new HashMap<>();
		for (char ch : values)
		{
			cache.put(ch, cache.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < values.length; i++)
		{
			if (cache.get(values[i]) == 1)
			{
				return i;
			}
		}

		return -1;
	}
}
