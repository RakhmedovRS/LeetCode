package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-23
 */
@LeetCode(
        id = 3492,
        name = "Maximum Containers on a Ship",
        url = "https://leetcode.com/problems/maximum-containers-on-a-ship/description/",
        difficulty = Difficulty.EASY
)
public class MaximumContainersOnShip {
    public int maxContainers(int n, int w, int maxWeight) {
        long left = 0;
        long right = (long) n * n * w;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid <= maxWeight) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans / w;
    }
}