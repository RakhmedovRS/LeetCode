package tasks;
import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-04
 */
@LeetCode(
id = 3701,
 name = "Compute Alternating Sum",
 url = "https://leetcode.com/problems/compute-alternating-sum/description/",
 difficulty = Difficulty.EASY
)
public class ComputeAlternatingSum {
    public int alternatingSum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result += nums[i];
            } else {
                result -= nums[i];
            }
        }
        return result;
    }
}