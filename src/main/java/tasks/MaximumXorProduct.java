package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/18/2023
 */
@LeetCode(
		id = 2939,
		name = "Maximum Xor Product",
		url = "https://leetcode.com/problems/maximum-xor-product/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumXorProduct
{
	int MOD = 1_000_000_007;

	public int maximumXorProduct(long a, long b, int n)
	{
		java.math.BigInteger A = java.math.BigInteger.valueOf(a);
		java.math.BigInteger B = java.math.BigInteger.valueOf(b);
		java.math.BigInteger res = A.multiply(B);
		for (int i = n - 1; i >= 0; i--)
		{
			java.math.BigInteger aA = A.xor(java.math.BigInteger.valueOf(1L << i));
			java.math.BigInteger bB = B.xor(java.math.BigInteger.valueOf(1L << i));
			java.math.BigInteger temp = aA.multiply(bB);
			if (temp.compareTo(res) > 0)
			{
				res = temp;
				A = aA;
				B = bB;
			}
		}

		return res.mod(java.math.BigInteger.valueOf(MOD)).intValue();
	}
}
