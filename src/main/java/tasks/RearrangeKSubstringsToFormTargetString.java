package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-23
 */
@LeetCode(
        id = 3365,
        name = "Rearrange K Substrings to Form Target String",
        url = "https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/",
        difficulty = Difficulty.MEDIUM
)
public class RearrangeKSubstringsToFormTargetString {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int len = s.length() / k;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += len) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int j = i; j < i + len; j++) {
                left.append(s.charAt(j));
                right.append(t.charAt(j));
            }

            String leftKey = left.toString();
            String rightKey = right.toString();

            map.put(leftKey, map.getOrDefault(leftKey, 0) + 1);
            map.put(rightKey, map.getOrDefault(rightKey, 0) - 1);
        }

        for (int balance : map.values()) {
            if (balance != 0) {
                return false;
            }
        }

        return true;
    }
}