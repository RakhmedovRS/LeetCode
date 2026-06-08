package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-06-07
 */
@LeetCode(
        id = 3950,
        name = "Exactly One Consecutive Set Bits Pair",
        url = "https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/description/",
        difficulty = Difficulty.EASY
)
public class ExactlyOneConsecutiveSetBitsPair {
    public boolean consecutiveSetBits(int n) {
        String bits = Integer.toBinaryString(n);
        boolean seen = false;
        for (int i = 1; i < bits.length(); i++) {
            if (bits.charAt(i - 1) == '1' && bits.charAt(i) == '1') {
                if (seen) {
                    return false;
                }
                seen = true;
            }
        }
        return seen;
    }
}