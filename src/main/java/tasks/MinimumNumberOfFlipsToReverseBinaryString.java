package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-22
 */
@LeetCode(
        id = 3750,
        name = "Minimum Number of Flips to Reverse Binary String",
        url = "https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/description/",
        difficulty = Difficulty.EASY
)
public class MinimumNumberOfFlipsToReverseBinaryString {
    public int minimumFlips(int n) {
        String val = Integer.toBinaryString(n);
        String reverse = new StringBuilder(val).reverse().toString();
        int ans = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) != reverse.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}