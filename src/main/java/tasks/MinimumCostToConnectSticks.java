package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 12/11/2020
 */
@LeetCode(
		id = 1167,
		name = "Minimum Cost to Connect Sticks",
		url = "https://leetcode.com/problems/minimum-cost-to-connect-sticks/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MinimumCostToConnectSticks
{
	public int connectSticks(int[] sticks)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int stick : sticks)
		{
			minHeap.add(stick);
		}

		int cost = 0;
		int x;
		int y;
		while (minHeap.size() > 1)
		{
			x = minHeap.remove();
			y = minHeap.remove();

			cost += x + y;

			minHeap.add(x + y);
		}

		return cost;
	}
}
