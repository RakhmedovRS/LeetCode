package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 27-Apr-20
 */
@LeetCode(
	id = 132,
	name = "Palindrome Partitioning II",
	url = "https://leetcode.com/problems/palindrome-partitioning-ii/",
	difficulty = Difficulty.MEDIUM
)
public class PalindromePartitioningII
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> answer = new ArrayList<>();
		dfs(0, s, new LinkedList<>(), answer);
		return answer;
	}

	private void dfs(int pos, String s, LinkedList<String> list, List<List<String>> answer)
	{
		if (pos == s.length())
		{
			answer.add(new ArrayList<>(list));
			return;
		}

		String sub;
		for (int i = pos + 1; i <= s.length(); i++)
		{
			sub = s.substring(pos, i);
			if (isPalindrome(sub))
			{
				list.addLast(sub);
				dfs(i, s, list, answer);
				list.removeLast();
			}
		}
	}

	private boolean isPalindrome(String string)
	{
		int left = 0;
		int right = string.length() - 1;
		while (left <= right)
		{
			if (string.charAt(left++) != string.charAt(right--))
			{
				return false;
			}
		}

		return true;
	}
}
