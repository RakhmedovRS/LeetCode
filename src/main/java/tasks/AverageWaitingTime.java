package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/26/2020
 */
@LeetCode(
	id = 1701,
	name = "Average Waiting Time",
	url = "https://leetcode.com/problems/average-waiting-time/",
	difficulty = Difficulty.MEDIUM
)
public class AverageWaitingTime
{
	public double averageWaitingTime(int[][] customers)
	{
		double idle = 0;
		int prev = -1;
		for (int[] customer : customers)
		{
			if (prev <= customer[0])
			{
				idle += customer[1];
				prev = customer[0] + customer[1];
			}
			else
			{
				idle += customer[1] + prev - customer[0];
				prev += customer[1];
			}
		}

		return idle / customers.length;
	}

	public static void main(String[] args)
	{
		AverageWaitingTime clazz = new AverageWaitingTime();
		System.out.println(clazz.averageWaitingTime(new int[][]
			{
				{1, 2},
				{2, 5},
				{4, 3}
			}));

		System.out.println(clazz.averageWaitingTime(new int[][]
			{
				{5, 2},
				{5, 4},
				{10, 3},
				{20, 1}
			}));
	}
}
