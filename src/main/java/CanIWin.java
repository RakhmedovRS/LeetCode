import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/5/2020
 */
@LeetCode(id = 464, name = "Can I Win", url = "https://leetcode.com/problems/can-i-win/")
public class CanIWin
{
	public boolean canIWin(int maxChoosableInteger, int desiredTotal)
	{
		if (maxChoosableInteger >= desiredTotal)
		{
			return true;
		}

		if (possibleMax(maxChoosableInteger) < desiredTotal)
		{
			return false;
		}

		return dfs(1 << maxChoosableInteger + 2, maxChoosableInteger, desiredTotal, new HashMap<>());
	}

	private boolean dfs(int used, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> memo)
	{
		if (desiredTotal <= 0)
		{
			return false;
		}

		if (memo.containsKey(used))
		{
			return memo.get(used);
		}

		boolean canWin = false;
		for (int i = maxChoosableInteger; i > 0; i--)
		{
			if ((used & (1 << i)) == 0)
			{
				used ^= (1 << i);
				if (!dfs(used, maxChoosableInteger, desiredTotal - i, memo))
				{
					canWin = true;
				}

				used ^= (1 << i);

				if (canWin)
				{
					break;
				}
			}
		}

		memo.put(used, canWin);

		return canWin;
	}

	private int possibleMax(int maxChoosableInteger)
	{
		int sum = 0;
		for (int i = 1; i <= maxChoosableInteger; i++)
		{
			sum += i;
		}

		return sum;
	}
}
