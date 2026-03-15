package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-14
 */
@LeetCode(
        id = 3867,
        name = "Sum of GCD of Formed Pairs",
        url = "https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/",
        difficulty = Difficulty.MEDIUM
)
public class SumOfGCDOfFormedPairs {
    public long gcdSum(int[] nums) {
        if (nums.length == 1) {
            return 0L;
        }

        int max = 0;
        int[] gcds = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            gcds[i] = gcd(nums[i], max);
        }

        Arrays.sort(gcds);

        long ans = 0;
        long[] next = new long[gcds.length / 2];
        for (int i = 0, left = 0, right = gcds.length - 1; i < next.length; i++, left++, right--) {
            next[i] = gcd(gcds[left], gcds[right]);
            ans += next[i];
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}