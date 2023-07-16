package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/6/2022
 */
@LeetCode(
		id = 2429,
		name = "Minimize XOR",
		url = "https://leetcode.com/problems/minimize-xor/",
		difficulty = Difficulty.MEDIUM
)
public class MinimizeXOR
{
	public int minimizeXor(int num1, int num2)
	{
		int count = Integer.bitCount(num2);
		int result = 0;
		boolean[] skip = new boolean[31];
		for (int i = 30; i >= 0 && count > 0; i--)
		{
			if ((num1 & (1 << i)) != 0)
			{
				result ^= (1 << i);
				count--;
				skip[i] = true;
			}
		}

		for (int i = 0; i < 30 && count > 0; i++)
		{
			if ((num1 & (1 << i)) == 0 && !skip[i])
			{
				result ^= (1 << i);
				count--;
			}
		}

		return result;
	}
}
