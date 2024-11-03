package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-02
 */
@LeetCode(
        id = 3340,
        name = "Check Balanced String",
        url = "https://leetcode.com/problems/check-balanced-string/description/",
        difficulty = Difficulty.EASY
)
public class CheckBalancedString {
    public boolean isBalanced(String num) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                even += (num.charAt(i) - '0');
            } else {
                odd += (num.charAt(i) - '0');
            }
        }
        return even == odd;
    }
}