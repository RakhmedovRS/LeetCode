package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/26/2022
 */
@LeetCode(
		id = 2317,
		name = "Maximum XOR After Operations",
		url = "https://leetcode.com/problems/maximum-xor-after-operations/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumXORAfterOperations
{
	public int maximumXOR(int[] nums)
	{
		int res = 0;
		for (int a : nums)
			res |= a;
		return res;
	}
}
