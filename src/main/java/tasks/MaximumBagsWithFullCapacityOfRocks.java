package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 5/22/2022
 */
@LeetCode(
	id = 2279,
	name = "Maximum Bags With Full Capacity of Rocks",
	url = "https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumBagsWithFullCapacityOfRocks
{
	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < capacity.length; i++)
		{
			pq.add(capacity[i] - rocks[i]);
		}

		int count = 0;
		while (additionalRocks > 0 && !pq.isEmpty())
		{
			int b = pq.remove();
			if (b == 0)
			{
				count++;
			}
			else
			{
				additionalRocks -= b;
				if (additionalRocks >= 0)
				{
					count++;
				}
			}
		}

		return count;
	}
}
