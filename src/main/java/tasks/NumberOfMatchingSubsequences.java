package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(id = 792, name = "Number of Matching Subsequences", url = "https://leetcode.com/problems/number-of-matching-subsequences/")
public class NumberOfMatchingSubsequences
{
	public int numMatchingSubseq(String S, String[] words)
	{
		int matches = 0;
		Map<String, Boolean> memo = new HashMap<>();
		for (String word : words)
		{
			Boolean match = memo.get(word);
			if (match == null)
			{
				int left = 0;
				int right = 0;
				while (left < S.length() && right < word.length())
				{
					if (S.charAt(left) == word.charAt(right))
					{
						right++;
					}
					left++;
				}
				match = right == word.length();
				memo.put(word, match);
			}
			matches += match ? 1 : 0;
		}

		return matches;
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
	}
}
