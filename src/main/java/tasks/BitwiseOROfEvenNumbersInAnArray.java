package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-20
 */
@LeetCode(
        id = 3688,
        name = "Bitwise OR of Even Numbers in an Array",
        url = "https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/description/",
        difficulty = Difficulty.EASY
)
public class BitwiseOROfEvenNumbersInAnArray {
    public int evenNumberBitwiseORs(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                res |= num;
            }
        }
        return res;
    }
}