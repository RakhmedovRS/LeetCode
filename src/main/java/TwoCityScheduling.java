import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(id = 1029, name = "Two City Scheduling", url = "https://leetcode.com/problems/two-city-scheduling/")
public class TwoCityScheduling
{
	public int twoCitySchedCost(int[][] costs)
	{
		Arrays.sort(costs, ((a, b) -> a[0] - a[1] - (b[0] - b[1])));

		int n = costs.length / 2;
		int total = 0;
		for (int i = 0; i < costs.length; i++)
		{
			if (i < n)
			{
				total += costs[i][0];
			}
			else
			{
				total += costs[i][1];
			}
		}

		return total;
	}
}
