package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-01-17
 */
@LeetCode(
        id = 3809,
        name = "Best Reachable Tower",
        url = "https://leetcode.com/problems/best-reachable-tower/description/",
        difficulty = Difficulty.MEDIUM
)
public class BestReachableTower {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int max = Integer.MIN_VALUE;
        int[] ans = new int[2];
        for (int[] tower : towers) {
            int distance = manhattanDistance(tower, center);
            if (distance <= radius && max < tower[2]) {
                ans = new int[]{tower[0], tower[1]};
                max = tower[2];
            } else if (distance <= radius && max <= tower[2]) {
                if (tower[0] < ans[0]) {
                    ans = new int[]{tower[0], tower[1]};
                } else if (tower[0] == ans[0] && tower[1] < ans[1]) {
                    ans = new int[]{tower[0], tower[1]};
                }
            }
        }
        return max == Integer.MIN_VALUE ? new int[]{-1, -1} : ans;
    }

    public static int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}