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

		return dfs(0, 0, s, t, false, new Boolean[s.length()][t.length()]);
	}

	private boolean dfs(int sPos, int tPos, String source, String target, boolean edited, Boolean[][] memo)
	{
		if (sPos == source.length())
		{
			return target.length() - tPos == (edited ? 0 : 1);
		}
		else if (tPos == target.length())
		{
			return source.length() - sPos == (edited ? 0 : 1);
		}

		if (memo[sPos][tPos] != null)
		{
			return memo[sPos][tPos];
		}

		if (source.charAt(sPos) == target.charAt(tPos))
		{
			memo[sPos][tPos] = dfs(sPos + 1, tPos + 1, source, target, edited, memo);
		}
		else
		{
			if (edited)
			{
				memo[sPos][tPos] = false;
				return false;
			}

			boolean a = dfs(sPos + 1, tPos + 1, source, target, true, memo);
			boolean b = dfs(sPos + 1, tPos, source, target, true, memo);
			boolean c = dfs(sPos, tPos + 1, source, target, true, memo);
			memo[sPos][tPos] = a || b || c;
		}

		return memo[sPos][tPos];
	}
}
