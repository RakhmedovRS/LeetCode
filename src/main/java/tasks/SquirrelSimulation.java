package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/13/2021
 */
@LeetCode(
		id = 573,
		name = "Squirrel Simulation",
		url = "https://leetcode.com/problems/squirrel-simulation/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class SquirrelSimulation {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int distance = 0;
		int maxDistance = Integer.MIN_VALUE;
		for (int[] nut : nuts) {
			distance += manhattanDistance(tree, nut) * 2;
			maxDistance = Math.max(maxDistance, manhattanDistance(tree, nut) - manhattanDistance(nut, squirrel));
		}

		return distance - maxDistance;
	}

	private int manhattanDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
