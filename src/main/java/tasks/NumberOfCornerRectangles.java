package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 29-Jan-21
 */
@LeetCode(
        id = 750,
        name = "Number Of Corner Rectangles",
        url = "https://leetcode.com/problems/number-of-corner-rectangles/",
        difficulty = Difficulty.MEDIUM
)
public class NumberOfCornerRectangles
{
    public int countCornerRectangles(int[][] grid)
    {
        int count = 0;

        int rows = grid.length;
        if (rows == 0)
        {
            return count;
        }
        int columns = grid[0].length;

        Map<Integer, Integer> memo = new HashMap<>();
        for (int row = 0; row < rows; row++)
        {
            for (int column1 = 0; column1 < columns; column1++)
            {
                if (grid[row][column1] == 1)
                {
                    for (int column2 = column1 + 1; column2 < columns; column2++)
                    {
                        if (grid[row][column2] == 1)
                        {
                            int position = column1 * 200 + column2;
                            int temp = memo.getOrDefault(position, 0);
                            count += temp;
                            memo.put(position, temp + 1);
                        }
                    }
                }
            }
        }

        return count;
    }
}
