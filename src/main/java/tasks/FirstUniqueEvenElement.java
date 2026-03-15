package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-14
 */
@LeetCode(
        id = 3866,
        name = "First Unique Even Element",
        url = "https://leetcode.com/problems/first-unique-even-element/description/",
        difficulty = Difficulty.EASY
)
public class FirstUniqueEvenElement {
    public int firstUniqueEven(int[] nums) {
        int[] memo = new int[101];
        for (int num : nums) {
            memo[num]++;
        }

        for (int num : nums) {
            if (memo[num] == 1 && num % 2 == 0) {
                return num;
            }
        }

        return -1;
    }
}