package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-25
 */
@LeetCode(
        id = 3560,
        name = "Find Minimum Log Transportation Cost",
        url = "https://leetcode.com/problems/find-minimum-log-transportation-cost/description/",
        difficulty = Difficulty.EASY
)
public class FindMinimumLogTransportationCost {
    public long minCuttingCost(int n, int m, int k) {
        long ans = 0;
        while (n > k) {
            int reminder = n - k;
            n -= reminder;
            ans += ((long) k * reminder);
        }

        while (m > k) {
            int reminder = m - k;
            m -= reminder;
            ans += ((long) m * reminder);
        }

        return ans;
    }
}