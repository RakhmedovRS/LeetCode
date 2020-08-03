import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Aug-20
 */
@LeetCode(id = 1419, name = "Minimum Number of Frogs Croaking", url = "https://leetcode.com/problems/minimum-number-of-frogs-croaking/")
public class MinimumNumberOfFrogsCroaking
{
	public int minNumberOfFrogs(String croakOfFrogs)
	{
		if (croakOfFrogs.length() % 5 != 0)
		{
			return -1;
		}

		int[] memo = new int[26];
		int max = 0;
		for (char ch : croakOfFrogs.toCharArray())
		{
			memo[ch - 'a']++;
			max = Math.max(max, memo[ch - 'a']);
			if (isCroak(memo))
			{
				memo['c' - 'a']--;
				memo['r' - 'a']--;
				memo['o' - 'a']--;
				memo['a' - 'a']--;
				memo['k' - 'a']--;
			}

			if (!isValid(memo))
			{
				return -1;
			}
		}

		for (int i = 0; i < 26; i++)
		{
			if (memo[i] > 0)
			{
				return -1;
			}
		}

		return max;
	}

	private boolean isCroak(int[] memo)
	{
		return memo['c' - 'a'] > 0
			&& memo['r' - 'a'] > 0
			&& memo['o' - 'a'] > 0
			&& memo['a' - 'a'] > 0
			&& memo['k' - 'a'] > 0;
	}

	private boolean isValid(int[] memo)
	{
		return memo['c' - 'a'] >= memo['r' - 'a']
			&& memo['r' - 'a'] >= memo['o' - 'a']
			&& memo['o' - 'a'] >= memo['a' - 'a']
			&& memo['a' - 'a'] >= memo['k' - 'a'];
	}
}
