/**
 * Longest Common Subsequence
 * LeetCode 1143
 *
 * @author RakhmedovRS
 * @created 16-Feb-20
 */
public class LongestCommonSubsequence
{
	public int longestCommonSubsequence(String s1, String s2)
	{
		int[][] cache = new int[s2.length() + 1][s1.length() + 1];

		for (int row = 0; row <= s2.length(); row++)
		{
			for (int column = 0; column <= s1.length(); column++)
			{
				if (row == 0 || column == 0)
				{
					cache[row][column] = 0;
				}
				else if (s2.charAt(row - 1) == s1.charAt(column - 1))
				{
					cache[row][column] = cache[row - 1][column - 1] + 1;
				}
				else
				{
					cache[row][column] = Math.max(cache[row - 1][column], cache[row][column - 1]);
				}
			}
		}

		return cache[s2.length()][s1.length()];
	}
}
