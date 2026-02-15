package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-14
 */
@LeetCode(
        id = 3843,
        name = "First Element with Unique Frequency",
        url = "https://leetcode.com/problems/first-element-with-unique-frequency/description/",
        difficulty = Difficulty.MEDIUM
)
public class FirstElementWithUniqueFrequency {
    public int firstUniqueFreq(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] freqs = new int[100_001];
        int[] seenFreqs = new int[100_001];
        for (int num : nums) {
            freqs[num]++;
        }

        for (int f : freqs) {
            seenFreqs[f]++;
        }

        for (int num : nums) {
            if (seenFreqs[freqs[num]] == 1) {
                return num;
            }
        }

        return -1;
    }
}