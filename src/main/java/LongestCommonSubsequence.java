import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Feb-20
 */
@LeetCode(id = 1143, name = "Longest Common Subsequence", url = "https://leetcode.com/problems/longest-common-subsequence/")
public class LongestCommonSubsequence
{
	public int longestCommonSubsequence(String text1, String text2)
	{
		return dfs(0, text1, 0, text2, new Integer[text1.length() + 1][text2.length() + 1]);
	}

	private int dfs(int pos1, String text1, int pos2, String text2, Integer[][] memo)
	{
		if (pos1 == text1.length() || pos2 == text2.length())
		{
			return 0;
		}

		if (memo[pos1][pos2] != null)
		{
			return memo[pos1][pos2];
		}

		if (text1.charAt(pos1) == text2.charAt(pos2))
		{
			memo[pos1][pos2] = 1 + dfs(pos1 + 1, text1, pos2 + 1, text2, memo);
		}
		else
		{
			memo[pos1][pos2] = Math.max(dfs(pos1 + 1, text1, pos2, text2, memo),
				dfs(pos1, text1, pos2 + 1, text2, memo));
		}

		return memo[pos1][pos2];
	}
}
