package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 6/5/2021
 */
@LeetCode(
		id = 1383,
		name = "Maximum Performance of a Team",
		url = "https://leetcode.com/problems/maximum-performance-of-a-team/",
		difficulty = Difficulty.HARD
)
public class MaximumPerformanceOfTeam
{
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k)
	{
		int[][] speedAndEfficiency = new int[n][2];
		for (int i = 0; i < n; i++)
		{
			speedAndEfficiency[i][0] = speed[i];
			speedAndEfficiency[i][1] = efficiency[i];
		}

		Arrays.sort(speedAndEfficiency, (a, b) -> b[1] - a[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		long sum = 0;
		long answer = 0;
		for (int[] sAndE : speedAndEfficiency)
		{
			pq.add(sAndE[0]);

			sum += sAndE[0];
			if (pq.size() > k)
			{
				sum -= pq.remove();
			}

			answer = Math.max(answer, (long) sum * sAndE[1]);
		}

		return (int) (answer % 1_000_000_007);
	}
}
