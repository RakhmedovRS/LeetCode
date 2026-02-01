package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-01
 */
@LeetCode(
        id = 3827,
        name = "Count Monobit Integers",
        url = "https://leetcode.com/problems/count-monobit-integers/description/",
        difficulty = Difficulty.EASY
)
public class CountMonobitIntegers {
    public int countMonobit(int n) {
        int ans = 0;
        outer:
        for (int i = 0; i <= n; i++) {
            String bits = Integer.toBinaryString(i);
            for (char b : bits.toCharArray()) {
                if (b != bits.charAt(0)) {
                    continue outer;
                }
            }
            ans++;
        }
        return ans;
    }
}