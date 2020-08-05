import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Aug-20
 */
@LeetCode(id = 474, name = "Ones and Zeroes", url = "https://leetcode.com/problems/ones-and-zeroes/")
public class OnesAndZeroes
{
	public int findMaxForm(String[] strings, int zeroes, int ones)
	{

		int[][] counts = new int[strings.length][2];
		for (int i = 0; i < strings.length; i++)
		{
			for (char ch : strings[i].toCharArray())
			{
				counts[i][ch - '0']++;
			}
		}

		int[][][] memo = new int[zeroes + 1][ones + 1][counts.length];

		return findMaxForm(counts, 0, memo, zeroes, ones);
	}

	private int findMaxForm(int[][] counts, int pos, int[][][] memo, int zeroes, int ones)
	{
		if (pos == counts.length)
		{
			return 0;
		}

		if (memo[zeroes][ones][pos] > 0)
		{
			return memo[zeroes][ones][pos];
		}

		if (zeroes - counts[pos][0] >= 0 && ones - counts[pos][1] >= 0)
		{
			memo[zeroes][ones][pos] = 1 + findMaxForm(counts, pos + 1, memo, zeroes - counts[pos][0], ones - counts[pos][1]);
		}

		memo[zeroes][ones][pos] = Math.max(memo[zeroes][ones][pos], findMaxForm(counts, pos + 1, memo, zeroes, ones));

		return memo[zeroes][ones][pos];
	}
}
