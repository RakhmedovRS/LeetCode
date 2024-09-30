package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-29
 */
@LeetCode(
        id = 3281,
        name = "Maximize Score of Numbers in Ranges",
        url = "https://leetcode.com/problems/maximize-score-of-numbers-in-ranges/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximizeScoreOfNumbersInRanges {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        if (d == 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < start.length; i++) {
                min = Math.min(min, start[i] - start[i - 1]);
            }
            return min;
        }

        long[] arr = new long[start.length];
        for (int i = 0; i < start.length; i++) {
            arr[i] = start[i];
        }

        long left = 0;
        long right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if (canAchieve(arr, mid, d)) {
                left = mid + 1;
                ans = (int) mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(long[] arr, long m, int d) {
        long prev = arr[0];
        long min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            long diff = arr[i] + d - prev;
            if (diff >= m) {
                long curr = Math.max(arr[i], prev + m);
                min = Math.min(min, curr - prev);
                prev = curr;
            } else return false;
        }

        return min >= m;
    }
}