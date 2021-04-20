package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/17/2021
 */
@LeetCode(
	id = 1829,
	name = "Maximum XOR for Each Query",
	url = "https://leetcode.com/problems/maximum-xor-for-each-query/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumXORForEachQuery
{
	public int[] getMaximumXor(int[] nums, int maximumBit)
	{
		int[] xor = new int[nums.length];
		xor[0] = nums[0];

		for (int i = 1; i < nums.length; i++)
		{
			xor[i] = xor[i - 1] ^ nums[i];
		}

		int[] answer = new int[nums.length];
		for (int i = 0, right = nums.length - 1; i < nums.length; i++, right--)
		{
			int targetNum = 0;
			int currentNum = xor[right];

			for (int bitPos = 0; bitPos < maximumBit; bitPos++)
			{
				if ((currentNum & 1) == 0)
				{
					targetNum ^= (1 << bitPos);
				}

				currentNum >>= 1;
			}

			answer[i] = targetNum;
		}

		return answer;
	}
}
