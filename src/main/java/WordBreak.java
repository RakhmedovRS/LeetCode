import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 20-Feb-20
 */
@LeetCode(id = 139, name = "Word Break", url = "https://leetcode.com/problems/word-break/")
public class WordBreak
{
	public boolean wordBreak(String string, List<String> wordDict)
	{
		return wordBreak(string, 0, new HashSet<>(wordDict), new HashMap<>());
	}

	private boolean wordBreak(String string, int startPos, Set<String> dictionary, Map<Integer, Map<Integer, Boolean>> cache)
	{
		if (startPos >= string.length())
		{
			return true;
		}

		Map<Integer, Boolean> map = cache.getOrDefault(startPos, new HashMap<>());

		for (int i = startPos; i <= string.length(); i++)
		{
			if (map.containsKey(i))
			{
				return map.get(i);
			}

			if (dictionary.contains(string.substring(startPos, i)))
			{
				map.put(i, true);
				boolean res = wordBreak(string, i, dictionary, cache);
				if (res)
				{
					return res;
				}
			}
			map.put(i, false);
			cache.put(startPos, map);
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
		System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
		System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
	}
}
