package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-20
 */
@LeetCode(
        id = 3522,
        name = "Calculate Score After Performing Instructions",
        url = "https://leetcode.com/problems/calculate-score-after-performing-instructions/description/",
        difficulty = Difficulty.MEDIUM
)
public class CalculateScoreAfterPerformingInstructions {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        boolean[] executed = new boolean[instructions.length];
        int pos = 0;
        while (pos >= 0 && pos < values.length) {
            if (executed[pos]) {
                break;
            }
            executed[pos] = true;
            if ("add".equals(instructions[pos])) {
                score += values[pos];
                pos++;
            } else {
                pos += values[pos];
            }
        }
        return score;
    }
}