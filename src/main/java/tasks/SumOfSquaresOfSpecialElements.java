package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/15/2023
 */
@LeetCode(
        id = 2778,
        name = "Sum of Squares of Special Elements",
        url = "https://leetcode.com/problems/sum-of-squares-of-special-elements/",
        difficulty = Difficulty.EASY
)
public class SumOfSquaresOfSpecialElements
{
    public int sumOfSquares(int[] nums)
    {
        int sum = 0;
        for (int i = 1, pos = 0; pos < nums.length; i++, pos++)
        {
            if (nums.length % i == 0)
            {
                sum += (nums[pos] * nums[pos]);
            }
        }

        return sum;
    }
}
