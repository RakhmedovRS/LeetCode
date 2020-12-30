import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/30/2020
 */
@LeetCode(
	id = 294,
	name = "Flip Game II",
	url = "https://leetcode.com/problems/flip-game-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class FlipGameII
{
	public boolean canWin(String s)
	{
		Map<String, Boolean[]> memo = new HashMap<>();
		return dfs(0, s.toCharArray(), memo);
	}

	private boolean dfs(int player, char[] state, Map<String, Boolean[]> memo)
	{
		String key = String.valueOf(state);
		if (memo.containsKey(key) && memo.get(key)[player] != null)
		{
			return memo.get(key)[player];
		}

		boolean current = false;
		boolean next;
		for (int i = 1; i < state.length; i++)
		{
			if (state[i - 1] == '+' && state[i] == '+')
			{
				state[i - 1] = '-';
				state[i] = '-';

				next = dfs((player + 1) % 2, state, memo);
				if (!next)
				{
					current = true;
				}

				state[i - 1] = '+';
				state[i] = '+';
			}
		}

		memo.putIfAbsent(key, new Boolean[2]);
		memo.get(key)[player] = current;
		return current;
	}
}
