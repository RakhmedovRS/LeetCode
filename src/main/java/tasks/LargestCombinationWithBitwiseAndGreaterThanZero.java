package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/15/2022
 */
@LeetCode(
	id = 2275,
	name = "Largest Combination With Bitwise AND Greater Than Zero",
	url = "https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/",
	difficulty = Difficulty.MEDIUM
)
public class LargestCombinationWithBitwiseAndGreaterThanZero
{
	public int largestCombination(int[] candidates)
	{
		List<char[]> bits = new ArrayList<>();
		for (int candidate : candidates)
		{
			char[] bit = new char[31];
			Arrays.fill(bit, '0');
			String bs = Integer.toBinaryString(candidate);
			int pos = 30;
			for (int i = bs.length() - 1; i >= 0; i--)
			{
				bit[pos--] = bs.charAt(i);
			}

			bits.add(bit);
		}

		int max = 0;
		for (int i = 0; i < 31; i++)
		{
			int current = 0;
			for (char[] bit : bits)
			{
				if (bit[i] == '1')
				{
					current++;
				}
			}

			max = Math.max(max, current);
		}

		return max;
	}
}
