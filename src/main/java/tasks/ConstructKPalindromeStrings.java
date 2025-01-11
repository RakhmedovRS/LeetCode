package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-01-11
 */
@LeetCode(
        id = 1400,
        name = "Construct K Palindrome Strings",
        url = "https://leetcode.com/problems/construct-k-palindrome-strings/description/",
        difficulty = Difficulty.MEDIUM
)
public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int[] chars = new int[26];
        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }

        int pairs = 0;
        int odd = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 != 0) {
                chars[i]--;
                odd++;
            }

            pairs += (chars[i] / 2);
        }

        return odd <= k && pairs * 2 >= (k - odd);
    }
}