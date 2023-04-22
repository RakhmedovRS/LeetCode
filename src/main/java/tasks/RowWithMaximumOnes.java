package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/21/2023
 */
@LeetCode(
        id = 2643,
        name = "Row With Maximum Ones",
        url = "https://leetcode.com/problems/row-with-maximum-ones/",
        difficulty = Difficulty.EASY
)
public class RowWithMaximumOnes
{
    public int[] rowAndMaximumOnes(int[][] mat)
    {
        int max = 0;
        int index = 0;
        for (int row = 0; row < mat.length; row++)
        {
            int curr = 0;
            for (int val : mat[row])
            {
                curr += val;
            }

            if (curr > max)
            {
                max = curr;
                index = row;
            }
        }
        return new int[]{index, max};
    }
}
