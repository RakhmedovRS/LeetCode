package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-29
 */
@LeetCode(
        id = 3913,
        name = "Sort Vowels by Frequency",
        url = "https://leetcode.com/problems/sort-vowels-by-frequency/description/",
        difficulty = Difficulty.MEDIUM
)
public class SortVowelsByFrequency {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.contains(ch)) {
                if (Character.isAlphabetic(ch)) {
                    freq[Character.toLowerCase(ch) - 'a']++;
                }
                pos.putIfAbsent(ch, i);
            }
        }

        LinkedList<Integer> ids = new LinkedList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                ids.add(i);
            }
        }

        ids.sort((a, b) -> {
            if (freq[a] == freq[b]) {
                return pos.get((char) (a + 'a')) - pos.get((char) (b + 'a'));
            }
            return freq[b] - freq[a];
        });

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                int i = ids.getFirst();
                freq[i]--;
                if (freq[i] == 0) {
                    ids.removeFirst();
                }
                sb.append((char) (i + 'a'));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
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