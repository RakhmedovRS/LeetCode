package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(
	id = 868,
	name = "Binary Gap",
	url = "https://leetcode.com/problems/binary-gap/",
	difficulty = Difficulty.EASY
)
public class BinaryGap
{
	public int binaryGap(int N)
	{
		if (N == 2)
		{
			return 0;
		}

		int max = 0;
		String binary = Integer.toBinaryString(N);
		int counts = 0;
		int ones = 0;
		for (int i = 0; i < binary.length(); i++)
		{
			if (binary.charAt(i) == '1')
			{
				ones++;
				max = Math.max(max, counts);
				counts = 0;
			}
			else if (ones > 0)
			{
				counts++;
			}
		}

		return ones > 1 ? max + 1 : 0;
	}
}
