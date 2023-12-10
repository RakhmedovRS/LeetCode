package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11-Feb-21
 */
@LeetCode(
		id = 1665,
		name = "Minimum Initial Energy to Finish Tasks",
		url = "https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/",
		difficulty = Difficulty.HARD
)
public class MinimumInitialEnergyToFinishTasks {
	public int minimumEffort(int[][] tasks) {
		Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

		int result = 0;
		int current = 0;
		for (int[] task : tasks) {
			if (current < task[1]) {
				result += (task[1] - current);
				current += (task[1] - current);
			}

			current -= task[0];
		}

		return result;
	}
}
