package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-22
 */
@LeetCode(
        id = 3876,
        name = "Construct Uniform Parity Array II",
        url = "https://leetcode.com/problems/construct-uniform-parity-array-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class ConstructUniformParityArrayII {
    public boolean uniformArray(int[] nums1) {
        int seenEven = 0;
        int minOdd = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (int num : nums1) {
            if (num % 2 == 0) {
                seenEven++;
            } else {
                minOdd = Math.min(minOdd, num);
                maxOdd = Math.max(maxOdd, num);
            }
        }

        if (seenEven == nums1.length) {
            return true;
        }

        int seenOdd = 0;
        for (int num : nums1) {
            if (num % 2 != 0) {
                seenOdd++;
            } else {
                if (num - minOdd >= 1) {
                    seenOdd++;
                }
            }
        }

        return seenOdd == nums1.length;
    }
}