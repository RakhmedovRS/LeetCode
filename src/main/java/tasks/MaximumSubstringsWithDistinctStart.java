package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-29
 */
@LeetCode(
        id = 3760,
        name = "Maximum Substrings With Distinct Start",
        url = "https://leetcode.com/problems/maximum-substrings-with-distinct-start/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumSubstringsWithDistinctStart {
    public int maxDistinct(String s) {
        boolean[] seen = new boolean[26];
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (!seen[ch - 'a']) {
                ans++;
            }
            seen[ch - 'a'] = true;
        }
        return ans;
    }
}