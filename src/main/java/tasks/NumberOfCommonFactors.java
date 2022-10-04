package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/4/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2427,
        name = "Number of Common Factors",
        url = "https://leetcode.com/problems/number-of-common-factors/",
        difficulty = Difficulty.EASY
)
public class NumberOfCommonFactors
{
    public int commonFactors(int a, int b)
    {
        int count = 0;
        for (int i = 1; i <= Math.min(a, b); i++)
        {
            if (a % i == 0 && b % i == 0)
            {
                count++;
            }
        }

        return count;
    }
}
