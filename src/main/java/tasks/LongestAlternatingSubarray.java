package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/8/2023
 */
@LeetCode(
        id = 2765,
        name = "Longest Alternating Subarray",
        url = "https://leetcode.com/problems/longest-alternating-subarray/",
        difficulty = Difficulty.EASY
)
public class LongestAlternatingSubarray
{
    public int alternatingSubarray(int[] nums)
    {
        int max = -1;
        outer:
        for (int i = 0; i < nums.length; i++)
        {
            boolean seen = false;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] - nums[j - 1] == 1 && !seen)
                {
                    max = Math.max(max, 1 + (j - i));
                    seen = true;
                }
                else if (nums[j] - nums[j - 1] == -1 && seen)
                {
                    max = Math.max(max, 1 + (j - i));
                    seen = false;
                }
                else
                {
                    continue outer;
                }
            }
        }
        return max;
    }
}
