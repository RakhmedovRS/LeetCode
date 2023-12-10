package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 21-Sep-20
 */
@LeetCode(
		id = 1094,
		name = "Car Pooling",
		url = "https://leetcode.com/problems/car-pooling/",
		difficulty = Difficulty.MEDIUM
)
public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		if (capacity <= 0) {
			return false;
		}

		Arrays.sort(trips, (a1, a2) ->
		{
			if (a1[1] == a2[1]) {
				return a1[2] - a2[2];
			}
			return a1[1] - a2[1];
		});

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
		int location;
		for (int[] trip : trips) {
			location = trip[1];
			while (!minHeap.isEmpty() && minHeap.peek()[2] <= location) {
				capacity += minHeap.remove()[0];
			}

			capacity -= trip[0];
			if (capacity < 0) {
				return false;
			}
			minHeap.add(trip);
		}

		return true;
	}
}
