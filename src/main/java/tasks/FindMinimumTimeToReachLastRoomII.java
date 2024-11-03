package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-02
 */
@LeetCode(
        id = 3342,
        name = "Find Minimum Time to Reach Last Room II",
        url = "https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindMinimumTimeToReachLastRoomII {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int columns = moveTime[0].length;
        //moveTime[rows - 1][columns - 1] = 0;
        Integer[][] memo = new Integer[rows][columns];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.add(new int[]{0, 0, 0, 0});
        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.remove();
            int time = curr[0];
            int row = curr[1];
            int column = curr[2];
            int additionalCost = curr[3];
            if (memo[row][column] != null && memo[row][column] <= time) {
                continue;
            }

            memo[row][column] = time;

            //up
            if (row - 1 >= 0) {
                priorityQueue.add(new int[]{1 + additionalCost + Math.max(time, moveTime[row - 1][column]), row - 1, column, (additionalCost + 1) % 2});
            }

            //down
            if (row + 1 < rows) {
                priorityQueue.add(new int[]{1 + additionalCost + Math.max(time, moveTime[row + 1][column]), row + 1, column, (additionalCost + 1) % 2});
            }

            //right
            if (column + 1 < columns) {
                priorityQueue.add(new int[]{1 + additionalCost + Math.max(time, moveTime[row][column + 1]), row, column + 1, (additionalCost + 1) % 2});
            }

            //left
            if (column - 1 >= 0) {
                priorityQueue.add(new int[]{1 + additionalCost + Math.max(time, moveTime[row][column - 1]), row, column - 1, (additionalCost + 1) % 2});
            }

        }

        return Math.min(memo[rows - 1][columns - 1], memo[rows - 1][columns - 1]);
    }
}