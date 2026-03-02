package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-01
 */
@LeetCode(
        id = 3856,
        name = "Trim Trailing Vowels",
        url = "https://leetcode.com/problems/trim-trailing-vowels/description/",
        difficulty = Difficulty.EASY
)
public class TrimTrailingVowels {
    public String trimTrailingVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 0 && vowelsSet.contains(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}