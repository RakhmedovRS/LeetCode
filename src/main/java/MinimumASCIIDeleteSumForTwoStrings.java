import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/24/2020
 */
@LeetCode(id = 712, name = "Minimum ASCII Delete Sum for Two Strings", url = "https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/")
public class MinimumASCIIDeleteSumForTwoStrings
{
	public int minimumDeleteSum(String s1, String s2)
	{
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Integer[][] memo = new Integer[chars1.length + 1][chars2.length + 1];
		return dfs(chars1, chars2, 0, 0, memo);
	}

	private int dfs(char[] chars1, char[] chars2, int pos1, int pos2, Integer[][] memo)
	{
		if (pos1 == chars1.length)
		{
			int sum = 0;
			for (; pos2 < chars2.length; pos2++)
			{
				sum += chars2[pos2];
			}

			return sum;
		}

		if (pos2 == chars2.length)
		{
			int sum = 0;
			for (; pos1 < chars1.length; pos1++)
			{
				sum += chars1[pos1];
			}

			return sum;
		}

		if (memo[pos1][pos2] != null)
		{
			return memo[pos1][pos2];
		}

		if (chars1[pos1] == chars2[pos2])
		{
			memo[pos1][pos2] = dfs(chars1, chars2, pos1 + 1, pos2 + 1, memo);
		}
		else
		{
			memo[pos1][pos2] = Math.min(chars1[pos1] + dfs(chars1, chars2, pos1 + 1, pos2, memo),
				chars2[pos2] + dfs(chars1, chars2, pos1, pos2 + 1, memo));
		}

		return memo[pos1][pos2];
	}
}
