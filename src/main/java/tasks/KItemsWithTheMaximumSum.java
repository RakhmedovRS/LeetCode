package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/26/2023
 */
@LeetCode(
		id = 2600,
		name = "K Items With the Maximum Sum",
		url = "https://leetcode.com/problems/k-items-with-the-maximum-sum/",
		difficulty = Difficulty.EASY
)
public class KItemsWithTheMaximumSum
{
	public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k)
	{
		int res = 0;
		res += Math.min(numOnes, k);
		k -= res;

		k -= Math.min(k, numZeros);

		res += -1 * Math.min(numNegOnes, k);
		return res;
	}
}
