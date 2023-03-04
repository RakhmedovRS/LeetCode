package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2/12/2023
 */
@LeetCode(
        id = 2562,
        name = "Find the Array Concatenation Value",
        url = "https://leetcode.com/problems/find-the-array-concatenation-value/description/",
        difficulty = Difficulty.EASY
)
public class FindTheArrayConcatenationValue
{
    public long findTheArrayConcVal(int[] nums)
    {
        int left = 0;
        int right = nums.length - 1;
        long res = 0;
        while (left <= right)
        {
            if (left == right)
            {
                res += nums[left++];
                continue;
            }
            res += (Long.parseLong("" + nums[left++] + nums[right--]));
        }

        return res;
    }
}
