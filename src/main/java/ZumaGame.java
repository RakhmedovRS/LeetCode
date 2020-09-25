import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 9/25/2020
 */
@LeetCode(id = 488, name = "Zuma Game", url = "https://leetcode.com/problems/zuma-game/")
public class ZumaGame
{
	public int findMinStep(String board, String hand)
	{
		char[] balls = new char[26];
		for (char ch : hand.toCharArray())
		{
			balls[ch - 'A']++;
		}
		Map<String, Integer> memo = new HashMap<>();
		dfs(board, balls, memo, 0);
		return memo.getOrDefault("", -1);
	}

	private void dfs(String board, char[] balls, Map<String, Integer> memo, int step)
	{
		if (board.isEmpty())
		{
			memo.put("", Math.min(step, memo.getOrDefault("", Integer.MAX_VALUE)));
			return;
		}

		if (memo.containsKey(board))
		{
			return;
		}

		int left;
		int right;
		char ch;
		memo.put(board, -1);
		for (int current = 0; current < board.length(); current++)
		{
			ch = board.charAt(current);

			left = current;
			right = current;
			while (left - 1 >= 0 && board.charAt(left - 1) == ch)
			{
				left--;
			}

			while (right + 1 < board.length() && board.charAt(right + 1) == ch)
			{
				right++;
			}

			current = right;

			if (right - left >= 2)
			{
				dfs(board.substring(0, left) + board.substring(right + 1), balls, memo, step);
			}
			else if (balls[ch - 'A'] == 0)
			{
				continue;
			}
			else if (right - left >= 1)
			{
				balls[ch - 'A']--;
				dfs(board.substring(0, left) + board.substring(right + 1), balls, memo, step + 1);
				balls[ch - 'A']++;
			}
			else if (balls[ch - 'A'] >= 2)
			{
				balls[ch - 'A'] -= 2;
				dfs(board.substring(0, left) + board.substring(right + 1), balls, memo, step + 2);
				balls[ch - 'A'] += 2;
			}
		}
	}
}
