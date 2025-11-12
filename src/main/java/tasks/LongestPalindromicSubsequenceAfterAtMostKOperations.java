package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-01
 */
@LeetCode(
        id = 3472,
        name = "Longest Palindromic Subsequence After at Most K Operations",
        url = "https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestPalindromicSubsequenceAfterAtMostKOperations {
    public int longestPalindromicSubsequence(String s, int k) {
        if (s.length() <= 1) {
            return s.length();
        }

        int[][][] memo = new int[s.length() + 1][s.length() + 1][k + 1];
        for (int[][] rows : memo) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        char[] chars = s.toCharArray();

        int[][] diffs = new int[26][26];
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                diffs[a - 'a'][b - 'a'] = findMinDistance(a, b);
            }
        }

        return findLongest(chars, 0, chars.length - 1, memo, k, diffs);
    }

    private int findLongest(char[] chars, int left, int right, int[][][] memo, int k, int[][] diffs) {
        if (left == right) {
            return 1;
        } else if (left > right) {
            return 0;
        }

        if (memo[left][right][k] != -1) {
            return memo[left][right][k];
        }

        int diff = diffs[chars[left] - 'a'][chars[right] - 'a'];
        if (diff == 0) {
            memo[left][right][k] = 2 + findLongest(chars, left + 1, right - 1, memo, k, diffs);
        } else if (k >= diff) {
            int res = 2 + findLongest(chars, left + 1, right - 1, memo, k - diff, diffs);
            res = Math.max(res, 2 + findLongest(chars, left + 1, right - 1, memo, k - diff, diffs));
            res = Math.max(res, findLongest(chars, left + 1, right, memo, k, diffs));
            res = Math.max(res, findLongest(chars, left, right - 1, memo, k, diffs));
            memo[left][right][k] = res;
        } else {
            memo[left][right][k] = Math.max(findLongest(chars, left + 1, right, memo, k, diffs),
                    findLongest(chars, left, right - 1, memo, k, diffs));
        }

        return memo[left][right][k];
    }

    private int findMinDistance(char a, char b) {
        if (a == b) {
            return 0;
        }

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int distance = 0;
        int left = a - 'a';
        int right = a - 'a';
        while (alphabet[left] != b && alphabet[right] != b) {
            left = (26 + (left - 1)) % 26;
            right = (right + 1) % 26;
            distance++;
        }

        return distance;
    }
}