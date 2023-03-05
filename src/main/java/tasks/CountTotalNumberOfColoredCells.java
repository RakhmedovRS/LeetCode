package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/5/2023
 */
@LeetCode(
        id = 2579,
        name = "Count Total Number of Colored Cells",
        url = "https://leetcode.com/problems/count-total-number-of-colored-cells/",
        difficulty = Difficulty.MEDIUM
)
public class CountTotalNumberOfColoredCells
{
    public long coloredCells(int n)
    {
        long res = 1 + (n - 1) * 2;
        long x = res;
        while (x > 1)
        {
            res += (x - 2) * 2;
            x -= 2;
        }

        return res;
    }
}
