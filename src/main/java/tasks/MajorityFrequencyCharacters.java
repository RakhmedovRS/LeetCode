package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-27
 */
@LeetCode(
        id = 3692,
        name = "Majority Frequency Characters",
        url = "https://leetcode.com/problems/majority-frequency-characters/description/",
        difficulty = Difficulty.EASY
)
public class MajorityFrequencyCharacters {
    public String majorityFrequencyGroup(String s) {
        int[] memo = new int[26];
        for (char ch : s.toCharArray()) {
            memo[ch - 'a']++;
        }

        int maxGroupSize = 0;
        int I = 0;
        for (int i = 100; i > 0; i--) {
            int count = 0;
            for (int f : memo) {
                if (i == f) {
                    count++;
                }
            }

            if (count > maxGroupSize) {
                maxGroupSize = count;
                I = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == I) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}