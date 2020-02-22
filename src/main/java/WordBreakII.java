import java.util.*;

/**
 * Word Break II
 * LeetCode 140
 *
 * @author RakhmedovRS
 * @created 22-Feb-20
 */
public class WordBreakII
{
	public List<String> wordBreak(String s, List<String> wordDict)
	{
		return wordBreakHelper(s, 0, new HashSet<>(wordDict), new HashMap<>());
	}

	private List<String> wordBreakHelper(String s, int start, Set<String> dictionary, Map<Integer, List<String>> memo)
	{
		if (memo.containsKey(start))
		{
			return memo.get(start);
		}

		List<String> validSubstring = new ArrayList<>();

		if (start == s.length())
		{
			validSubstring.add("");
		}

		for (int end = start + 1; end <= s.length(); end++)
		{
			String prefix = s.substring(start, end);

			if (dictionary.contains(prefix))
			{
				List<String> suffixes = wordBreakHelper(s, end, dictionary, memo);

				for (String suffix : suffixes)
				{
					validSubstring.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
				}
			}
		}
		memo.put(start, validSubstring);
		return memo.get(start);
	}

	public static void main(String[] args)
	{
		System.out.println(new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
	}
}
