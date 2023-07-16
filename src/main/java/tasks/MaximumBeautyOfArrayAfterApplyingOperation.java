package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 7/15/2023
 */
@LeetCode(
        id = 2779,
        name = "Maximum Beauty of an Array After Applying Operation",
        url = "https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumBeautyOfArrayAfterApplyingOperation
{
    public int maximumBeauty(int[] nums, int k)
    {
        Arrays.sort(nums);

        int left = 0;
        int right = 0;

        int curr = 0;
        int max = 1;
        while (right < nums.length)
        {
            while (right < nums.length && nums[right] - nums[left] <= k * 2)
            {
                right++;
                curr++;
                max = Math.max(max, curr);
            }

            while (right < nums.length && nums[right] - nums[left] > k * 2)
            {
                left++;
                curr--;
            }
        }

        return max;
    }
}
