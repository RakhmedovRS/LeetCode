package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/10/2021
 */
@LeetCode(
	id = 1822,
	name = "Sign of the Product of an Array",
	url = "https://leetcode.com/problems/sign-of-the-product-of-an-array/",
	difficulty = Difficulty.EASY
)
public class SignOfTheProductOfArray
{
	public int arraySign(int[] nums)
	{
		int res = 1;
		for (int num : nums)
		{
			res *= Integer.compare(num, 0);
		}

		return res;
	}
}
