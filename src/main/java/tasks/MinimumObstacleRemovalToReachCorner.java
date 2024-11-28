package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-28
 */
@LeetCode(
        id = 2290,
        name = "Minimum Obstacle Removal to Reach Corner",
        url = "https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/",
        difficulty = Difficulty.HARD
)
public class MinimumObstacleRemovalToReachCorner {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Integer[][] memo = new Integer[rows][columns];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.isEmpty() && memo[rows - 1][columns - 1] == null) {
            int[] curr = pq.remove();
            int row = curr[0];
            int column = curr[1];
            int cost = curr[2] + grid[row][column];
            if (memo[row][column] != null && memo[row][column] <= cost) {
                continue;
            }
            memo[row][column] = cost;
            for (int[] step : steps) {
                int r = step[0];
                int c = step[1];
                if (row + r >= 0 && row + r < rows && column + c >= 0 && column + c < columns) {
                    pq.add(new int[]{row + r, column + c, cost});
                }
            }
        }
        return memo[rows - 1][columns - 1];
    }
}