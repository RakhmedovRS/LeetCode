package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-09
 */
@LeetCode(
        id = 3926,
        name = "Count Valid Word Occurrences",
        url = "https://leetcode.com/problems/count-valid-word-occurrences/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountValidWordOccurrences {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for (String chunk : chunks) {
            sb.append(chunk);
        }

        String s = sb.toString();
        Map<String, Integer> freq = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isLetter(ch)) {
                word.append(ch);
            } else if (
                    ch == '-' &&
                            i > 0 &&
                            i < s.length() - 1 &&
                            isLetter(s.charAt(i - 1)) &&
                            isLetter(s.charAt(i + 1))) {
                word.append(ch);
            } else {
                addWord(freq, word);
            }
        }

        addWord(freq, word);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = freq.getOrDefault(queries[i], 0);
        }

        return ans;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private void addWord(Map<String, Integer> freq, StringBuilder word) {
        if (word.isEmpty()) {
            return;
        }

        String w = word.toString();
        freq.put(w, freq.getOrDefault(w, 0) + 1);

        word.setLength(0);
    }
}