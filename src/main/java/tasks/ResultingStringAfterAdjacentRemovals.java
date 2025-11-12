package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-25
 */
@LeetCode(
        id = 3561,
        name = "Resulting String After Adjacent Removals",
        url = "https://leetcode.com/problems/resulting-string-after-adjacent-removals/description/",
        difficulty = Difficulty.MEDIUM
)
public class ResultingStringAfterAdjacentRemovals {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char ch : s.toCharArray()) {
            if (sb.length() > 0) {
                char prev = alphabet[((ch - 'a' - 1) + 26) % 26];
                char next = alphabet[(ch - 'a' + 1) % 26];
                if (sb.charAt(sb.length() - 1) == prev || sb.charAt(sb.length() - 1) == next) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}