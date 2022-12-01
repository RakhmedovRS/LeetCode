package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/30/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2485,
        name = "Find the Pivot Integer",
        url = "https://leetcode.com/problems/find-the-pivot-integer/",
        difficulty = Difficulty.EASY
)
public class FindThePivotInteger
{
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum += i;
        }

        int s = 0;
        for (int i = 1; i <= n; i++)
        {
            s += i;

            if (s == sum)
            {
                return i;
            }

            sum -= i;
        }

        return -1;
    }
}
