package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/10/2021
 */
@LeetCode(
		id = 1891,
		name = "Cutting Ribbons",
		url = "https://leetcode.com/problems/cutting-ribbons/",
		difficulty = Difficulty.MEDIUM
)
public class CuttingRibbons
{
	public int maxLength(int[] ribbons, int k)
	{
		int min = 1;
		int middle;
		int max = 1_000_000_000;
		int candidate = 0;
		while (min <= max)
		{
			middle = (min + max) / 2;
			int count = 0;
			for (int ribbon : ribbons)
			{
				count += ribbon / middle;
			}

			if (count >= k)
			{
				candidate = middle;
				min = middle + 1;
			}
			else
			{
				max = middle - 1;
			}
		}

		return candidate;
	}
}
