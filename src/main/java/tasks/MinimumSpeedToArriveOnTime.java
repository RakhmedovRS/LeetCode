package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/23/2021
 */
@LeetCode(
		id = 1870,
		name = "Minimum Speed to Arrive on Time",
		url = "https://leetcode.com/problems/minimum-speed-to-arrive-on-time/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumSpeedToArriveOnTime {
	public int minSpeedOnTime(int[] dist, double hour) {
		int answer = Integer.MAX_VALUE;
		int min = 1;
		int max = 1_000_000_000;
		int mid;
		while (min <= max) {
			mid = (max + min) / 2;
			double time = 0;
			for (int i = 0; i < dist.length; i++) {
				if (i == dist.length - 1) {
					time += (double) dist[i] / mid;
				}
				else {
					if (dist[i] % mid == 0) {
						time += dist[i] / mid;
					}
					else {
						time += dist[i] / mid + 1;
					}
				}
			}

			if (time <= hour) {
				max = mid - 1;
				answer = mid;
			}
			else {
				min = mid + 1;
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}
