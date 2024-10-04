package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-03
 */
@LeetCode(
        id = 3286,
        name = "Find a Safe Walk Through a Grid",
        url = "https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindSafeWalkThroughGrid {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        if (grid.get(0).get(0) > health || grid.get(rows - 1).get(cols - 1) > health) {
            return false;
        }
        Integer[][] memo = new Integer[rows][cols];

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, health - grid.get(0).get(0)});
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int h = cur[2];
            if (memo[row][col] == null || memo[row][col] < h) {
                memo[row][col] = h;
                for (int[] d : directions) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        int newH = h - grid.get(newRow).get(newCol);
                        if (newH > 0) {
                            queue.add(new int[]{newRow, newCol, h - grid.get(newRow).get(newCol)});
                            if (newRow == rows - 1 && newCol == cols - 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return memo[rows - 1][cols - 1] != null && memo[rows - 1][cols - 1] >= 0;
    }
}