package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-06-07
 */
@LeetCode(
        id = 3952,
        name = "Maximum Total Value of Covered Indices",
        url = "https://leetcode.com/problems/maximum-total-value-of-covered-indices/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumTotalValueOfCoveredIndices {
    public long maxTotal(int[] nums, String s) {
        long ans = 0;
        int i = 0;

        while (i < nums.length) {
            if (s.charAt(i) == '0') {
                i++;
                continue;
            }

            int l = i;

            while (i < nums.length && s.charAt(i) == '1') {
                i++;
            }

            int r = i - 1;

            if (l == 0) {
                for (int j = 0; j <= r; j++) {
                    ans += nums[j];
                }
            } else {
                long sum = 0;
                int minVal = Integer.MAX_VALUE;

                for (int j = l - 1; j <= r; j++) {
                    sum += nums[j];
                    minVal = Math.min(minVal, nums[j]);
                }

                ans += sum - minVal;
            }
        }

        return ans;
    }
}