package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/9/2022
 */
@LeetCode(
		id = 2432,
		name = "The Employee That Worked on the Longest Task",
		url = "https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/",
		difficulty = Difficulty.EASY
)
public class TheEmployeeThatWorkedOnTheLongestTask {
	public int hardestWorker(int n, int[][] logs) {
		int maxId = Integer.MAX_VALUE;
		int maxTime = 0;
		int prevTime = 0;

		for (int i = 0; i < logs.length; i++) {
			if (logs[i][1] - prevTime >= maxTime) {
				if (logs[i][1] - prevTime == maxTime) {
					maxId = Math.min(maxId, logs[i][0]);
				}
				else {
					maxId = logs[i][0];
				}
			}

			maxTime = Math.max(maxTime, logs[i][1] - prevTime);
			prevTime = logs[i][1];
		}

		return maxId;
	}
}
