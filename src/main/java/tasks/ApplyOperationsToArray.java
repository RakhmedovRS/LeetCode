package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/6/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2460,
        name = "Apply Operations to an Array",
        url = "https://leetcode.com/problems/apply-operations-to-an-array/",
        difficulty = Difficulty.EASY
)
public class ApplyOperationsToArray
{
    public int[] applyOperations(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] == nums[i + 1])
            {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                for (int j = i + 1; j < nums.length; j++)
                {
                    if (nums[j] != 0)
                    {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }

        return nums;
    }
}
