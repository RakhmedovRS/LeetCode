package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-04
 */
@LeetCode(
        id = 3889,
        name = "Mirror Frequency Distance",
        url = "https://leetcode.com/problems/mirror-frequency-distance/description/",
        difficulty = Difficulty.MEDIUM
)
public class MirrorFrequencyDistance {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> memo = createCharFrequencyTable(s);
        int ans = 0;
        for (char a = '0', b = '9'; a < b; a++, b--) {
            ans += Math.abs(memo.getOrDefault(a, 0) - memo.getOrDefault(b, 0));
        }

        for (char a = 'a', b = 'z'; a < b; a++, b--) {
            ans += Math.abs(memo.getOrDefault(a, 0) - memo.getOrDefault(b, 0));
        }

        return ans;
    }

    public static Map<Character, Integer> createCharFrequencyTable(String word) {
        Map<Character, Integer> memo = new HashMap<>();
        for (char ch : word.toCharArray()) {
            memo.put(ch, memo.getOrDefault(ch, 0) + 1);
        }

        return memo;
    }
}