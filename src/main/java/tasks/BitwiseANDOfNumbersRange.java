package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Apr-20
 */
@LeetCode(
		id = 201,
		name = "Bitwise AND of Numbers Range",
		url = "https://leetcode.com/problems/bitwise-and-of-numbers-range/",
		difficulty = Difficulty.MEDIUM
)
public class BitwiseANDOfNumbersRange
{
	public int rangeBitwiseAnd(int m, int n)
	{
		int count = 0;
		while (m != n)
		{
			m = m >> 1;
			n = n >> 1;
			count++;
		}

		return m << count;
	}
}
