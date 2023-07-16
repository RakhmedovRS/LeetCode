package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2/22/2023
 */
@LeetCode(
		id = 1011,
		name = "Capacity To Ship Packages Within D Days",
		url = "https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/",
		difficulty = Difficulty.MEDIUM
)
public class CapacityToShipPackagesWithinDDays
{
	public int shipWithinDays(int[] weights, int days)
	{
		int min = 0;
		int max = Integer.MAX_VALUE;
		int mid;
		int candidate = Integer.MAX_VALUE;
		while (min <= max)
		{
			mid = (min + max) / 2;
			if (isPossibleToShip(weights, days, mid))
			{
				candidate = mid;
				max = mid - 1;
			}
			else
			{
				min = mid + 1;
			}
		}

		return candidate;
	}

	private boolean isPossibleToShip(int[] weights, int days, int capacity)
	{
		int pos = 0;
		for (int day = 0; day < days; day++)
		{
			int current = capacity;
			while (current > 0 && pos < weights.length)
			{
				if (current - weights[pos] < 0)
				{
					break;
				}

				current -= weights[pos++];
			}
		}

		return pos >= weights.length;
	}
}
