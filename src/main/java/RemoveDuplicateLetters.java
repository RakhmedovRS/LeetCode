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

		LinkedList<Character> deque = new LinkedList<>();
		boolean[] used = new boolean[26];
		for (char ch : chars)
		{
			memo[ch - 'a']--;
			if (used[ch - 'a'])
			{
				continue;
			}

			while (!deque.isEmpty() && ch < deque.peek() && memo[deque.getFirst() - 'a'] > 0)
			{
				used[deque.removeFirst() - 'a'] = false;
			}

			deque.addFirst(ch);
			used[ch - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder(26);
		for (Character ch : deque)
		{
			sb.append(ch);
		}
		return sb.reverse().toString();
	}
}
