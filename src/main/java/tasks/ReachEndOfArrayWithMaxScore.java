package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-29
 */
@LeetCode(
        id = 3282,
        name = "Reach End of Array With Max Score",
        url = "https://leetcode.com/problems/reach-end-of-array-with-max-score/description/",
        difficulty = Difficulty.MEDIUM
)
public class ReachEndOfArrayWithMaxScore {
    public long findMaximumScore(List<Integer> nums) {
        long sum = (long) (nums.size() - 1 - nums.get(0)) * nums.get(0);
        long currSum = 0;
        int currIndex = 0;
        int currVal = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (currVal < nums.get(i) || i == nums.size() - 1) {
                currSum += (long) (i - currIndex) * currVal;
                currVal = nums.get(i);
                currIndex = i;
            }
        }

        return Math.max(sum, currSum);
    }
}