package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/26/2022
 */
@LeetCode(
        id = 2481,
        name = "Minimum Cuts to Divide a Circle",
        url = "https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/",
        difficulty = Difficulty.EASY
)
public class MinimumCutsЕoDivideCircle
{
    public int numberOfCuts(int n)
    {
        if (n <= 1)
        {
            return 0;
        }

        if (n % 2 == 0)
        {
            return n / 2;
        }

        return n;
    }
}
