package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-May-20
 */
@LeetCode(id = 338, name = "Counting Bits", url = "https://leetcode.com/problems/counting-bits/")
public class CountingBits
{
	public int[] countBits1(int num)
	{
		int[] answer = new int[num + 1];

		for (int i = 1; i <= num; i++)
		{
			answer[i] = Integer.bitCount(i);
		}
		return answer;
	}

	public int[] countBits(int num)
	{
		int[] answer = new int[num + 1];
		boolean[] number = new boolean[32];
		int pos;
		boolean add;
		int bitCount = 0;
		for (int i = 1; i <= num; i++)
		{
			add = true;
			pos = 0;
			while (add && pos < 32)
			{
				if (number[pos])
				{
					number[pos] = false;
					bitCount--;
				}
				else
				{
					add = false;
					number[pos] = true;
					bitCount++;
				}
				pos++;
			}

			answer[i] = bitCount;
		}
		return answer;
	}
}
