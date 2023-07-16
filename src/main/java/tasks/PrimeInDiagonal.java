package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/9/2023
 */
@LeetCode(
		id = 2614,
		name = "Prime In Diagonal",
		url = "https://leetcode.com/problems/prime-in-diagonal/",
		difficulty = Difficulty.EASY
)
public class PrimeInDiagonal
{
	private boolean isPrime(int number)
	{
		if (number == 1)
		{
			return false;
		}
		int root = (int) Math.sqrt(number);
		for (int i = 2; i <= root; i++)
		{
			if (number % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	public int diagonalPrime(int[][] nums)
	{
		int max = 0;
		for (int row = 0, column = 0; row < nums.length && column < nums[row].length; row++, column++)
		{
			if (isPrime(nums[row][column]))
			{
				max = Math.max(max, nums[row][column]);
			}
		}

		for (int row = nums.length - 1, column = 0; row >= 0 && column < nums[row].length; row--, column++)
		{
			if (isPrime(nums[row][column]))
			{
				max = Math.max(max, nums[row][column]);
			}
		}

		return max;
	}
}
