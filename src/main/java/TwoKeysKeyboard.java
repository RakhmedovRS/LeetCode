import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(id = 650, name = "Keys Keyboard", url = "https://leetcode.com/problems/2-keys-keyboard/")
public class TwoKeysKeyboard
{
	public int minSteps(int n)
	{
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i++)
		{
			dp[i] = i;
			for (int j = i - 1; j > 1; j--)
			{
				if (i % j == 0)
				{
					dp[i] = dp[j] + (i / j);
					break;
				}
			}
		}

		return dp[n];
	}
}
