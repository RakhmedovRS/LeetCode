package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-02
 */
@LeetCode(
        id = 3341,
        name = "Find Minimum Time to Reach Last Room I",
        url = "https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindMinimumTimeToReachLastRoomI {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int columns = moveTime[0].length;
        //moveTime[rows - 1][columns - 1] = 0;
        Integer[][] memo = new Integer[rows][columns];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.add(new int[]{0, 0, 0});
        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.remove();
            int time = curr[0];
            int row = curr[1];
            int column = curr[2];
            if (memo[row][column] != null && memo[row][column] <= time) {
                continue;
            }

            memo[row][column] = time;

            //up
            if (row - 1 >= 0) {
                priorityQueue.add(new int[]{1 + Math.max(time, moveTime[row - 1][column]), row - 1, column});
            }

            //down
            if (row + 1 < rows) {
                priorityQueue.add(new int[]{1 + Math.max(time, moveTime[row + 1][column]), row + 1, column});
            }

            //right
            if (column + 1 < columns) {
                priorityQueue.add(new int[]{1 + Math.max(time, moveTime[row][column + 1]), row, column + 1});
            }

            //left
            if (column - 1 >= 0) {
                priorityQueue.add(new int[]{1 + Math.max(time, moveTime[row][column - 1]), row, column - 1});
            }

        }

        return memo[rows - 1][columns - 1];
    }
}