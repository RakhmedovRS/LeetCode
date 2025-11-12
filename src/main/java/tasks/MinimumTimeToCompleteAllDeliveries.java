package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-01
 */
@LeetCode(
        id = 3733,
        name = "Minimum Time to Complete All Deliveries",
        url = "https://leetcode.com/problems/minimum-time-to-complete-all-deliveries/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumTimeToCompleteAllDeliveries {
    public long minimumTime(int[] d, int[] r) {
        long left = 1;
        long right = Long.MAX_VALUE;
        long ans = Integer.MAX_VALUE;
        long lcm = lcm(r[0], r[1]);
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long res = delivered(mid, lcm, d, r);
            if (res >= d[0] + d[1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private long delivered(long time, long lcm, int[] d, int[] r) {
        long d1Time = Math.min((long) d[0], time - time / r[0]);
        long d2Time = Math.min((long) d[1], time - time / r[1]);
        long combined = time - time / lcm;
        return Math.min(combined, d1Time + d2Time);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}