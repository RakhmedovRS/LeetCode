package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-21
 */
@LeetCode(
        id = 3028,
        name = "Ant on the Boundary",
        url = "https://leetcode.com/problems/ant-on-the-boundary/description/",
        difficulty = Difficulty.EASY
)
public class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int ans = 0;
        int pos = 0;
        for (int num : nums) {
            pos += num;
            if (pos == 0) {
                ans++;
            }
        }
        return ans;
    }
}