import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/10/2021
 */
@LeetCode(
	id = 1824,
	name = "Minimum Sideway Jumps",
	url = "https://leetcode.com/problems/minimum-sideway-jumps/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumSidewayJumps
{
	public int minSideJumps(int[] obstacles)
	{
		Integer[][] memo = new Integer[4][obstacles.length];
		return dfs(0, 2, obstacles, memo);
	}

	private int dfs(int pos, int line, int[] obstacles, Integer[][] memo)
	{
		if (pos == obstacles.length - 1)
		{
			return 0;
		}

		if (memo[line][pos] != null)
		{
			return memo[line][pos];
		}

		if (obstacles[pos + 1] == line)
		{
			if (line == 1)
			{
				if (obstacles[pos] == 0)
				{
					memo[line][pos] = 1 + Math.min(dfs(pos, 2, obstacles, memo), dfs(pos, 3, obstacles, memo));
				}
				else if (obstacles[pos] == 2)
				{
					memo[line][pos] = 1 + dfs(pos, 3, obstacles, memo);
				}
				else
				{
					memo[line][pos] = 1 + dfs(pos, 2, obstacles, memo);
				}
			}
			else if (line == 2)
			{
				if (obstacles[pos] == 0)
				{
					memo[line][pos] = 1 + Math.min(dfs(pos, 1, obstacles, memo), dfs(pos, 3, obstacles, memo));
				}
				else if (obstacles[pos] == 1)
				{
					memo[line][pos] = 1 + dfs(pos, 3, obstacles, memo);
				}
				else
				{
					memo[line][pos] = 1 + dfs(pos, 1, obstacles, memo);
				}
			}
			else
			{
				if (obstacles[pos] == 0)
				{
					memo[line][pos] = 1 + Math.min(dfs(pos, 1, obstacles, memo), dfs(pos, 2, obstacles, memo));
				}
				else if (obstacles[pos] == 1)
				{
					memo[line][pos] = 1 + dfs(pos, 2, obstacles, memo);
				}
				else
				{
					memo[line][pos] = 1 + dfs(pos, 1, obstacles, memo);
				}
			}
		}
		else
		{
			memo[line][pos] = dfs(pos + 1, line, obstacles, memo);
		}

		return memo[line][pos];
	}
}
