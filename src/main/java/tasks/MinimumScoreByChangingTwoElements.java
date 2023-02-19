package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2/19/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2567,
        name = "Minimum Score by Changing Two Elements",
        url = "https://leetcode.com/problems/minimum-score-by-changing-two-elements/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumScoreByChangingTwoElements
{
    public int minimizeSum(int[] nums)
    {
        if (nums.length == 3)
        {
            return 0;
        }

        Arrays.sort(nums);

        int exceptFirstTwo = nums[nums.length - 1] - nums[2];
        int exceptLastTwo = nums[nums.length - 3] - nums[0];
        int exceptFirstAndLst = nums[nums.length - 2] - nums[1];
        return Math.min(exceptFirstTwo, Math.min(exceptLastTwo, exceptFirstAndLst));
    }
}
