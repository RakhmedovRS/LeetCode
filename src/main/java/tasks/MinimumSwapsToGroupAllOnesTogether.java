package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/14/2020
 */
@LeetCode(
		id = 1151,
		name = "Minimum Swaps to Group All 1's Together",
		url = "https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MinimumSwapsToGroupAllOnesTogether
{
	public int minSwaps(int[] data)
	{
		int onesCount = 0;
		for (int d : data)
		{
			onesCount += d;
		}

		if (onesCount == 0)
		{
			return 0;
		}

		int min = onesCount;
		int currentCount = 0;
		int left = 0;
		int right = 0;
		while (right < data.length)
		{
			currentCount += data[right++];

			if (right - left > onesCount)
			{
				currentCount -= data[left++];
			}


			if (right - left == onesCount)
			{
				min = Math.min(min, onesCount - currentCount);
			}
		}

		return min;
	}
}
