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
		int onceCount = 0;
		for (int d : data)
		{
			onceCount += d;
		}

		if (onceCount == 1)
		{
			return 0;
		}

		int min = data.length;
		int left = 0;
		int right = 0;
		int count = 0;
		while (right < data.length)
		{
			count += data[right];
			if (right - left >= onceCount - 1)
			{
				if (right - left >= onceCount)
				{
					count -= data[left++];
				}
				min = Math.min(min, onceCount - count);
			}
			right++;
		}

		return min;
	}
}
