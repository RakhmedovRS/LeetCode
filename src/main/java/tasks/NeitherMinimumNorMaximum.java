package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 6/11/2023
 */
@LeetCode(
        id = 2733,
        name = "Neither Minimum nor Maximum",
        url = "https://leetcode.com/problems/neither-minimum-nor-maximum/",
        difficulty = Difficulty.EASY
)
public class NeitherMinimumNorMaximum
{
    public int findNonMinOrMax(int[] nums)
    {
        if (nums.length < 3)
        {
            return -1;
        }
        Arrays.sort(nums);
        return nums[1];
    }
}
