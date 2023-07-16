package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Feb-20
 */
@LeetCode(
		id = 1143,
		name = "Longest Common Subsequence",
		url = "https://leetcode.com/problems/longest-common-subsequence/",
		difficulty = Difficulty.MEDIUM
)
public class LongestCommonSubsequence
{
	public int longestCommonSubsequence(String text1, String text2)
	{
		char[] chars1 = text1.toCharArray();
		char[] chars2 = text2.toCharArray();
		Integer[][] memo = new Integer[chars1.length][chars2.length];
		return dfs(0, 0, chars1, chars2, memo);
	}

	private int dfs(int pos1, int pos2, char[] chars1, char[] chars2, Integer[][] memo)
	{
		if (pos1 == chars1.length || pos2 == chars2.length)
		{
			return 0;
		}

		if (memo[pos1][pos2] != null)
		{
			return memo[pos1][pos2];
		}

		if (chars1[pos1] == chars2[pos2])
		{
			memo[pos1][pos2] = Math.max(1 + dfs(pos1 + 1, pos2 + 1, chars1, chars2, memo),
					Math.max(dfs(pos1 + 1, pos2, chars1, chars2, memo),
							dfs(pos1, pos2 + 1, chars1, chars2, memo)
					));
		}
		else
		{
			memo[pos1][pos2] = Math.max(dfs(pos1 + 1, pos2, chars1, chars2, memo),
					dfs(pos1, pos2 + 1, chars1, chars2, memo)
			);
		}

		return memo[pos1][pos2];
	}
}
