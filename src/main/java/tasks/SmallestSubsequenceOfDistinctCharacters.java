package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(id = 1081, name = "Smallest Subsequence of Distinct Characters", url = "https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/")
public class SmallestSubsequenceOfDistinctCharacters
{
	public String smallestSubsequence(String text)
	{
		int[] memo = new int[26];
		char[] chars = text.toCharArray();
		for (char ch : chars)
		{
			memo[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		boolean[] seen = new boolean[26];
		Deque<Character> deque = new LinkedList<>();
		for (char ch : chars)
		{
			memo[ch - 'a']--;
			if (seen[ch - 'a'])
			{
				continue;
			}

			while (!deque.isEmpty() && deque.peek() > ch && memo[deque.peek() - 'a'] > 0)
			{
				seen[deque.pop() - 'a'] = false;
			}
			deque.push(ch);
			seen[ch - 'a'] = true;
		}

		while (!deque.isEmpty())
		{
			sb.append(deque.removeLast());
		}

		return sb.toString();
	}
}
