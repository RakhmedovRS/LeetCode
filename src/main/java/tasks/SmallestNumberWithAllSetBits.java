package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-30
 */
@LeetCode(
        id = 3370,
        name = "Smallest Number With All Set Bits",
        url = "https://leetcode.com/problems/smallest-number-with-all-set-bits/",
        difficulty = Difficulty.EASY
)
public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        Arrays.fill(chars, '1');
        return Integer.parseInt(new String(chars), 2);
    }
}