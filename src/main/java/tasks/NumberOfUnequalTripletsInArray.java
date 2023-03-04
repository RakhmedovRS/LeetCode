package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/23/2022
 */
@LeetCode(
        id = 2475,
        name = "Number of Unequal Triplets in Array",
        url = "https://leetcode.com/problems/number-of-unequal-triplets-in-array/",
        difficulty = Difficulty.EASY
)
public class NumberOfUnequalTripletsInArray
{
    public int unequalTriplets(int[] nums)
    {
        int r = 0;
        for (int a = 0; a < nums.length; a++)
        {
            for (int b = a + 1; b < nums.length; b++)
            {
                for (int c = b + 1; c < nums.length; c++)
                {
                    if (nums[a] != nums[b] && nums[b] != nums[c] && nums[c] != nums[a])
                    {
                        r++;
                    }
                }
            }
        }

        return r;
    }
}
