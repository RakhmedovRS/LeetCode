package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/30/2020
 */
@LeetCode(
	id = 1133,
	name = "Largest Unique Number",
	url = "https://leetcode.com/problems/largest-unique-number/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class LargestUniqueNumber
{
	public int largestUniqueNumber(int[] A)
	{
		int[] numbers = new int[1001];
		for (int num: A)
		{
			numbers[num]++;
		}

		for (int i = 1000; i >=0; i--)
		{
			if (numbers[i] == 1)
			{
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		LargestUniqueNumber clazz = new LargestUniqueNumber();

		System.out.println(clazz.largestUniqueNumber(new int[]{}));
		System.out.println(clazz.largestUniqueNumber(new int[]{5,7,3,9,4,9,8,3,1}));
		System.out.println(clazz.largestUniqueNumber(new int[]{9,9,8,8}));
	}
}
