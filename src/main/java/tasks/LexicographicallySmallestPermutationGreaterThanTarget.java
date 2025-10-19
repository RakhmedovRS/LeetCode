package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-18
 */
@LeetCode(
        id = 3720,
        name = "Lexicographically Smallest Permutation Greater Than Target",
        url = "https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/description/",
        difficulty = Difficulty.MEDIUM
)
public class LexicographicallySmallestPermutationGreaterThanTarget {
    public String lexGreaterPermutation(String s, String target) {
        int[] freqTable = createCharFrequencyTable(s);
        char[] ans = new char[target.length()];
        String[] result = new String[]{null};
        if (dfs(0, ans, freqTable, target, result)) {
            return result[0];
        }
        return "";
    }

    private boolean dfs(int pos, char[] ans, int[] freqTable, String target, String[] result) {
        if (pos >= target.length()) {
            result[0] = String.valueOf(ans);
            return result[0].compareTo(target) > 0;
        }

        char targetChar = target.charAt(pos);

        if (freqTable[targetChar - 'a'] > 0) {
            ans[pos] = targetChar;
            freqTable[targetChar - 'a']--;
            if (dfs(pos + 1, ans, freqTable, target, result)) {
                return true;
            } else {
                freqTable[targetChar - 'a']++;
                ans[pos] = 0;
            }
        }

        int searchPos = (targetChar - 'a') + 1;
        while (searchPos < freqTable.length) {
            if (freqTable[searchPos] > 0) {
                ans[pos] = (char) (searchPos + 'a');
                freqTable[searchPos]--;
                fillInWithSmallest(pos + 1, ans, freqTable);
                if (dfs(target.length(), ans, freqTable, target, result)) {
                    return true;
                } else {
                    ans[pos] = 0;
                    freqTable[pos]++;
                    return false;
                }
            }
            searchPos++;
        }

        return false;
    }

    private void fillInWithSmallest(int pos, char[] ans, int[] freqTable) {
        for (int j = 0; j < freqTable.length; j++) {
            while (freqTable[j] != 0) {
                ans[pos++] = (char) (j + 'a');
                freqTable[j]--;
            }
        }
    }

    public static int[] createCharFrequencyTable(String word) {
        int[] pattern = new int[26];
        for (char ch : word.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                pattern[Character.toLowerCase(ch) - 'a']++;
            }
        }

        return pattern;
    }
}