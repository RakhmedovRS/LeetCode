package tasks;

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
		int ones = S.charAt(0) == '1' ? 1 : 0;
		int[] memo = new int[S.length()];
		for (int i = 1; i < S.length(); i++)
		{
			if (S.charAt(i) == '1')
			{
				memo[i] = memo[i - 1];
				ones++;
			}
			else
			{
				memo[i] = Math.min(1 + memo[i - 1], ones);
			}
		}

		return memo[memo.length - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("100000001010000"));
		System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00011000"));
		System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("010110"));
		System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00110"));
	}
}
