package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-01
 */
@LeetCode(
        id = 3443,
        name = "Maximum Manhattan Distance After K Changes",
        url = "https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumManhattanDistanceAfterKChanges {
    public int maxDistance(String s, int k) {
        int ans = 0;
        for (char i : "NS".toCharArray()) {
            for (char j : "WE".toCharArray()) {
                int K = k;
                int x = 0;
                int y = 0;
                for (char ch : s.toCharArray()) {
                    if (ch != i && ch != j && K > 0) {
                        if (ch == 'N') {
                            ch = 'S';
                        } else if (ch == 'S') {
                            ch = 'N';
                        } else if (ch == 'W') {
                            ch = 'E';
                        } else {
                            ch = 'W';
                        }
                        K--;
                    }

                    if (ch == 'N') {
                        y--;
                    } else if (ch == 'S') {
                        y++;
                    } else if (ch == 'W') {
                        x--;
                    } else {
                        x++;
                    }

                    ans = Math.max(ans, manhattanDistance(new int[]{0, 0}, new int[]{x, y}));
                }
            }
        }
        return ans;
    }

    public static int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}