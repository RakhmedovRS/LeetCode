package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-09
 */
@LeetCode(
        id = 3927,
        name = "Minimize Array Sum Using Divisible Replacements",
        url = "https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimizeArraySumUsingDivisibleReplacements {
    public long minArraySum(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = i * 2; j < counts.length; j += i) {
                    if (counts[j] > 0) {
                        counts[i] += counts[j];
                        counts[j] = 0;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < counts.length; i++) {
            ans += (long) i * counts[i];
        }
        return ans;
    }
}