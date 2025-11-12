package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-21
 */
@LeetCode(
        id = 2917,
        name = "Find the K-or of an Array",
        url = "https://leetcode.com/problems/find-the-k-or-of-an-array/description/",
        difficulty = Difficulty.EASY
)
public class FindTheKorOfAnArray {
    public int findKOr(int[] nums, int k) {
        int[] bits = new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) > 0) {
                    bits[i]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (bits[i] >= k) {
                ans ^= (1 << i);
            }
        }
        return ans;
    }
}