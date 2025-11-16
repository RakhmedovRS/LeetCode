package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-15
 */
@LeetCode(
        id = 3746,
        name = "Minimum String Length After Balanced Removals",
        url = "https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumStringLengthAfterBalancedRemovals {
    public int minLengthAfterRemovals(String s) {
        LinkedList<Character> chars = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (chars.isEmpty()) {
                chars.addLast(ch);
            } else {
                if (ch == 'a' && chars.getLast() == 'b') {
                    chars.removeLast();
                } else if (ch == 'b' && chars.getLast() == 'a') {
                    chars.removeLast();
                } else {
                    chars.addLast(ch);
                }
            }
        }
        return chars.size();
    }
}