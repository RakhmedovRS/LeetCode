package tasks;

import common.Difficulty;
import common.LeetCode;

@LeetCode(
		id = 2651,
		name = "Calculate Delayed Arrival Time",
		url = "https://leetcode.com/problems/calculate-delayed-arrival-time/",
		difficulty = Difficulty.EASY
)
public class CalculateDelayedArrivalTime {
	public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
		return (arrivalTime + delayedTime) % 24;
	}
}
