package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-28
 */
@LeetCode(
        id = 3301,
        name = "Maximize the Total Height of Unique Towers",
        url = "https://leetcode.com/problems/maximize-the-total-height-of-unique-towers/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximizeTheTotalHeightOfUniqueTowers {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long sum = 0;
        Set<Integer> used = new HashSet<>();
        int lastUsed = 0;
        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            if (i == maximumHeight.length - 1) {
                sum += maximumHeight[i];
                lastUsed = maximumHeight[i];
            } else {
                int res = Math.min(lastUsed - 1, maximumHeight[i]);
                if (res <= 0) {
                    return -1;
                }
                lastUsed = res;
                sum += res;
            }
        }
        return sum;
    }
}