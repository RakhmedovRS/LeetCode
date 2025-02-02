package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-01
 */
@LeetCode(
        id = 3442,
        name = "Maximum Difference Between Even and Odd Frequency I",
        url = "https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/",
        difficulty = Difficulty.EASY
)
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public int maxDifference(String s) {
        int[] freq = createCharFrequencyTable(s);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < freq.length; i++) {
            for (int j = i + 1; j < freq.length; j++) {
                int I = freq[i] % 2;
                int J = freq[j] % 2;
                if (I != J && freq[i] > 0 && freq[j] > 0) {
                    if (I == 0) {
                        max = Math.max(max, freq[j] - freq[i]);
                    } else {
                        max = Math.max(max, freq[i] - freq[j]);
                    }
                }
            }
        }

        return max;
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