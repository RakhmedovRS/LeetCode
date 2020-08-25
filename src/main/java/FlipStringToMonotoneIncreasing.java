import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Aug-20
 */
@LeetCode(id = 926, name = "Flip String to Monotone Increasing", url = "https://leetcode.com/problems/flip-string-to-monotone-increasing/")
public class FlipStringToMonotoneIncreasing
{
	public int minFlipsMonoIncr(String S)
	{
		Integer[] memo = new Integer[S.length()];
		int[] prefix = new int[S.length()];
		int sum = 0;
		for (int i = 0; i < prefix.length; i++)
		{
			if (S.charAt(i) == '1')
			{
				sum++;
			}

			prefix[i] = sum;
		}

		return dfs(S.toCharArray(), S.length() - 1, memo, prefix);
	}

	private int dfs(char[] s, int index, Integer[] memo, int[] prefix)
	{
		if (index < 0)
		{
			return 0;
		}

		if (memo[index] != null)
		{
			return memo[index];
		}

		if (s[index] == '1')
		{
			memo[index] = dfs(s, index - 1, memo, prefix);
		}
		else
		{
			memo[index] = Math.min(1 + dfs(s, index - 1, memo, prefix), prefix[index]);
		}

		return memo[index];
	}
}
