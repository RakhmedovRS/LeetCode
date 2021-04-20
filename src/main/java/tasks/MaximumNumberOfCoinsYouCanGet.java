package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 23-Aug-20
 */
@LeetCode(id = 1561, name = "Maximum Number of Coins You Can Get", url = "https://leetcode.com/problems/maximum-number-of-coins-you-can-get/")
public class MaximumNumberOfCoinsYouCanGet
{
	public int maxCoins(int[] piles)
	{
		Arrays.sort(piles);
		int left = 0;
		int right = piles.length - 1;
		int sum = 0;
		while (left < right)
		{
			left++;
			right--;
			sum += piles[right--];
		}

		return sum;
	}
}
