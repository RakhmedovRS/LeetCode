package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-16
 */
@LeetCode(
        id = 3683,
        name = "Earliest Time to Finish One Task",
        url = "https://leetcode.com/problems/earliest-time-to-finish-one-task/description/",
        difficulty = Difficulty.EASY
)
public class EarliestTimeToFinishOneTask {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            min = Math.min(min, task[0] + task[1]);
        }
        return min;
    }
}