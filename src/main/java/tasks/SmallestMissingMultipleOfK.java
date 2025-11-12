package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-18
 */
@LeetCode(
        id = 3718,
        name = "Smallest Missing Multiple of K",
        url = "https://leetcode.com/problems/smallest-missing-multiple-of-k/description/",
        difficulty = Difficulty.EASY
)
public class SmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int add = k;
        while (set.contains(k)) {
            k += add;
        }
        return k;
    }
}