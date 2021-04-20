package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/14/2021
 */
@LeetCode(
	id = 1758,
	name = "Minimum Changes To Make Alternating Binary String",
	url = "https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/",
	difficulty = Difficulty.EASY
)
public class MinimumChangesToMakeAlternatingBinaryString
{
	public int minOperations(String s)
	{
		int operationsA = 0;
		char[] chars = s.toCharArray();
		for (int i = 1; i < chars.length; i++)
		{
			if (chars[i] == chars[i - 1])
			{
				operationsA++;
				chars[i] = chars[i] == '0' ? '1' : '0';
			}
		}

		int operationsB = 1;
		chars = s.toCharArray();
		chars[0] = chars[0] == '0' ? '1' : '0';

		for (int i = 1; i < chars.length; i++)
		{
			if (chars[i] == chars[i - 1])
			{
				operationsB++;
				chars[i] = chars[i] == '0' ? '1' : '0';
			}
		}

		return Math.min(operationsA, operationsB);
	}

	public static void main(String[] args)
	{
		MinimumChangesToMakeAlternatingBinaryString clazz = new MinimumChangesToMakeAlternatingBinaryString();

		System.out.println(clazz.minOperations("01101011"));
		System.out.println(clazz.minOperations("10010100"));
		System.out.println(clazz.minOperations("1111"));
		System.out.println(clazz.minOperations("11111"));
	}
}
