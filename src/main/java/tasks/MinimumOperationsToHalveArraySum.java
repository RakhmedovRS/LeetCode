package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 3/19/2022
 */
@LeetCode(
	id = 2208,
	name = "Minimum Operations to Halve Array Sum",
	url = "https://leetcode.com/problems/minimum-operations-to-halve-array-sum/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToHalveArraySum
{
	public int halveArray(int[] nums)
	{
		int steps = 0;
		double initialSum = 0;
		double currentSum = 0;
		PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums)
		{
			initialSum += num;
			currentSum += num;
			pq.add((double) num);
		}

		while (currentSum > initialSum / 2)
		{
			double c = pq.remove();
			c /= 2;
			currentSum -= c;
			pq.add(c);
			steps++;
		}

		return steps;
	}
}
