package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/27/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2482,
        name = "Difference Between Ones and Zeros in Row and Column",
        url = "https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/",
        difficulty = Difficulty.MEDIUM
)
public class DifferenceBetweenOnesAndZerosInRowAndColumn
{
    public int[][] onesMinusZeros(int[][] grid)
    {
        int rows = grid.length;
        int columns = grid[0].length;

        int[] rZeroes = new int[rows];
        int[] rOnes = new int[rows];

        int[] cZeroes = new int[columns];
        int[] cOnes = new int[columns];

        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                if (grid[row][column] == 0)
                {
                    rZeroes[row]++;
                    cZeroes[column]++;
                }
                else
                {
                    rOnes[row]++;
                    cOnes[column]++;
                }
            }
        }

        int[][] answer = new int[rows][columns];
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                answer[row][column] = rOnes[row] + cOnes[column] - rZeroes[row] - cZeroes[column];
            }
        }

        return answer;
    }
}
