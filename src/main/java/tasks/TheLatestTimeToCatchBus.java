package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 7/10/2022
 */
@LeetCode(
		id = 2332,
		name = "The Latest Time to Catch a Bus",
		url = "https://leetcode.com/problems/the-latest-time-to-catch-a-bus/",
		difficulty = Difficulty.MEDIUM
)
public class TheLatestTimeToCatchBus {
	public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
		Arrays.sort(buses);
		Arrays.sort(passengers);
		int passIndex = 0;
		int latestTime = Math.min(passengers[passIndex] - 1, buses[0]);
		for (int bus : buses) {
			int numOfPass = 0;

			while (passIndex < passengers.length && passengers[passIndex] <= bus && numOfPass < capacity) {
				if (passIndex == 0 || (passIndex > 0 && (passengers[passIndex] - passengers[passIndex - 1] > 1))) {
					latestTime = passengers[passIndex] - 1;
				}

				numOfPass++;
				passIndex++;
			}

			if (passIndex == 0 || (passIndex > 0 && numOfPass < capacity && passengers[passIndex - 1] != bus)) {
				latestTime = bus;
			}
		}

		return latestTime;
	}
}
