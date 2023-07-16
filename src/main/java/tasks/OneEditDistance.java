package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/14/2020
 */
@LeetCode(
		id = 161,
		name = "One Edit Distance",
		url = "https://leetcode.com/problems/one-edit-distance/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class OneEditDistance
{
	public boolean isOneEditDistance(String s, String t)
	{
		if (s.isEmpty() && t.isEmpty())
		{
			return false;
		}
		else if ((s.isEmpty() && t.length() == 1) || (t.isEmpty() && s.length() == 1))
		{
			return true;
		}

		Boolean[][] memo = new Boolean[s.length()][t.length()];
		return dfs(0, 0, s.toCharArray(), t.toCharArray(), memo, false);
	}

	private boolean dfs(int posA, int posB, char[] aChars, char[] bChars, Boolean[][] memo, boolean seenMismatch)
	{
		if (posA == aChars.length)
		{
			return bChars.length - posB == (seenMismatch ? 0 : 1);
		}
		else if (posB == bChars.length)
		{
			return aChars.length - posA == (seenMismatch ? 0 : 1);
		}

		if (memo[posA][posB] != null)
		{
			return memo[posA][posB];
		}

		boolean result = false;
		if (aChars[posA] == bChars[posB])
		{
			result = dfs(posA + 1, posB + 1, aChars, bChars, memo, seenMismatch);
		}
		else if (!seenMismatch)
		{
			result = dfs(posA + 1, posB + 1, aChars, bChars, memo, true)
					|| dfs(posA + 1, posB, aChars, bChars, memo, true)
					|| dfs(posA, posB + 1, aChars, bChars, memo, true);
		}

		memo[posA][posB] = result;
		return result;
	}
}
