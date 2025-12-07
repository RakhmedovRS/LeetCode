package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-07
 */
@LeetCode(
        id = 3769,
        name = "Sort Integers by Binary Reflection",
        url = "https://leetcode.com/problems/sort-integers-by-binary-reflection/description/",
        difficulty = Difficulty.EASY
)
public class SortIntegersByBinaryReflection {
    public int[] sortByReflection(int[] nums) {
        List<int[]> values = new ArrayList<>();
        for (int num : nums) {
            values.add(new int[]{num, Integer.parseInt(new StringBuilder(Integer.toBinaryString(num)).reverse().toString(), 2)});
        }

        values.sort((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = values.get(i)[0];
        }
        return nums;
    }
}