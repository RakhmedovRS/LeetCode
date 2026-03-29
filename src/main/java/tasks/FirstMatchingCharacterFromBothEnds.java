package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-28
 */
@LeetCode(
        id = 3884,
        name = "First Matching Character From Both Ends",
        url = "https://leetcode.com/problems/first-matching-character-from-both-ends/description/",
        difficulty = Difficulty.EASY
)
public class FirstMatchingCharacterFromBothEnds {
    public int firstMatchingIndex(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                return l;
            }
            l++;
            r--;
        }

        return -1;
    }
}