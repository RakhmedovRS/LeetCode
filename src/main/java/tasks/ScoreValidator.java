package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-09
 */
@LeetCode(
        id = 3921,
        name = "Score Validator",
        url = "https://leetcode.com/problems/score-validator/description/",
        difficulty = Difficulty.EASY
)
public class ScoreValidator {
    public int[] scoreValidator(String[] events) {
        int[] ans = new int[2];
        for (String s : events) {
            if (ans[1] == 10) {
                break;
            }

            if (Character.isDigit(s.charAt(0))) {
                ans[0] += Integer.parseInt(s);
            } else if (s.length() == 1) {
                ans[1]++;
            } else {
                ans[0]++;
            }
        }
        return ans;
    }
}