import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(id = 316, name = "Remove Duplicate Letters", url = "https://leetcode.com/problems/remove-duplicate-letters/")
public class RemoveDuplicateLetters
{
	public String removeDuplicateLetters(String s)
	{
		int[] memo = new int[26];
		char[] chars = s.toCharArray();
		for (char ch : chars)
		{
			memo[ch - 'a']++;
		}

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

		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty())
		{
			sb.append(deque.removeLast());
		}

		return sb.toString();
	}
}
