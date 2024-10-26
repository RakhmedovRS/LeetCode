package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-26
 */
@LeetCode(
        id = 3330,
        name = "Find the Original Typed String I",
        url = "https://leetcode.com/problems/find-the-original-typed-string-i/description/",
        difficulty = Difficulty.EASY
)
public class FindTheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        int dupes = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                dupes++;
            }
        }

        return dupes + 1;
    }
}