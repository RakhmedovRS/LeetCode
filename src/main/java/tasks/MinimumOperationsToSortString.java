package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-07
 */
@LeetCode(
        id = 3863,
        name = "Minimum Operations to Sort a String",
        url = "https://leetcode.com/problems/minimum-operations-to-sort-a-string/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToSortString {
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        if (isSorted(chars)) {
            return 0;
        } else if (chars.length == 2) {
            return -1;
        }

        char[] copy1 = Arrays.copyOf(chars, chars.length);
        sort(0, copy1.length - 1, copy1);

        if (isSorted(copy1)) {
            return 1;
        }


        char[] copy2 = Arrays.copyOf(chars, chars.length);
        sort(1, copy1.length, copy2);

        if (isSorted(copy2)) {
            return 1;
        }

        sort(1, copy1.length, copy1);

        if (isSorted(copy1)) {
            return 2;
        }

        sort(0, copy2.length - 1, copy2);

        if (isSorted(copy2)) {
            return 2;
        }

        return 3;
    }

    private void sort(int start, int end, char[] chars) {
        int[] memo = new int[26];
        for (int i = start; i < end; i++) {
            memo[chars[i] - 'a']++;
        }

        int pos = start;
        for (int i = 0; i < memo.length; i++) {
            while (memo[i]-- > 0) {
                chars[pos++] = (char) (i + 'a');
            }
        }
    }

    private boolean isSorted(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] > chars[i]) {
                return false;
            }
        }
        return true;
    }
}