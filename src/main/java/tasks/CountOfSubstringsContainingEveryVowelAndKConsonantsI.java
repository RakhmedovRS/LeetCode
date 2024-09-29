package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-28
 */
@LeetCode(
        id = 3305,
        name = "Count of Substrings Containing Every Vowel and K Consonants I",
        url = "https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountOfSubstringsContainingEveryVowelAndKConsonantsI {
    public int countOfSubstrings(String word, int k) {
        int ans = 0;
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < word.length(); i++) {
            int[] vowels = new int[26];
            int[] consonants = new int[26];
            for (char v : vowelsSet) {
                consonants[v - 'a'] = Integer.MAX_VALUE;
            }
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (vowelsSet.contains(ch)) {
                    vowels[ch - 'a']++;
                } else {
                    consonants[ch - 'a']++;
                }

                if (containsConsonants(consonants, k) == 0 && containsAllVowels(vowels, vowelsSet)) {
                    ans++;
                }
            }
        }
        return ans;
    }


    private boolean containsAllVowels(int[] vowels, Set<Character> vowelsSet) {
        for (char v : vowelsSet) {
            if (vowels[v - 'a'] == 0) {
                return false;
            }
        }
        return true;
    }

    private int containsConsonants(int[] consonants, int k) {
        for (int i = 0; i < consonants.length; i++) {
            if (consonants[i] != Integer.MAX_VALUE) {
                k -= consonants[i];
            }
        }
        return k;
    }
}