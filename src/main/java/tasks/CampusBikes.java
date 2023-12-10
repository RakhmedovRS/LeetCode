package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/17/2020
 */
@LeetCode(
		id = 1057,
		name = "Campus Bikes",
		url = "https://leetcode.com/problems/campus-bikes/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class CampusBikes {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		int[] answer = new int[workers.length];
		List<int[]> pairs = new ArrayList<>();
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				pairs.add(new int[]{i, j});
			}
		}

		pairs.sort((a, b) ->
		{
			int[] w1 = workers[a[0]];
			int[] b1 = bikes[a[1]];
			int m1 = manhattanDistance(w1, b1);

			int[] w2 = workers[b[0]];
			int[] b2 = bikes[b[1]];
			int m2 = manhattanDistance(w2, b2);

			if (m1 == m2) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}
				else {
					return a[0] - b[0];
				}
			}

			return m1 - m2;
		});

		int left = workers.length;
		boolean[] usedWorkers = new boolean[workers.length];
		boolean[] usedBikes = new boolean[bikes.length];
		for (int[] pair : pairs) {
			if (left == 0) {
				break;
			}

			if (!usedWorkers[pair[0]] && !usedBikes[pair[1]]) {
				usedWorkers[pair[0]] = true;
				usedBikes[pair[1]] = true;
				answer[pair[0]] = pair[1];
				left--;
			}
		}

		return answer;
	}

	private int manhattanDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
