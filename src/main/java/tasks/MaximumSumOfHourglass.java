package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/5/2022
 */
@LeetCode(
        id = 2428,
        name = "Maximum Sum of an Hourglass",
        url = "https://leetcode.com/problems/maximum-sum-of-an-hourglass/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumSumOfHourglass
{
    public int maxSum(int[][] grid)
    {
        int rows = grid.length;
        int columns = grid[0].length;
        int max = 0;
        for (int row = 1; row < rows - 1; row++)
        {
            for (int column = 1; column < columns - 1; column++)
            {
                int a = grid[row - 1][column - 1];
                int b = grid[row - 1][column];
                int c = grid[row - 1][column + 1];
                int d = grid[row][column];
                int e = grid[row + 1][column - 1];
                int f = grid[row + 1][column];
                int g = grid[row + 1][column + 1];

                max = Math.max(max, a + b + c + d + e + f + g);
            }
        }

        return max;
    }
}
