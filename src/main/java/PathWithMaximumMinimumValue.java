import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 31-Jan-21
 */
@LeetCode(
        id = 1102,
        name = "Path With Maximum Minimum Value",
        url = "https://leetcode.com/problems/path-with-maximum-minimum-value/",
        difficulty = Difficulty.MEDIUM
)
public class PathWithMaximumMinimumValue
{
    public int maximumMinimumPath(int[][] A)
    {
        int rows = A.length;
        int columns = A[0].length;
        int[][] memo = new int[rows][columns];
        for (int[] row : memo)
        {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, A[0][0]});

        int[] current;
        int row;
        int column;
        int nextRow;
        int nextColumn;
        int minMax;
        int[][] steps = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty())
        {
            current = queue.remove();
            row = current[0];
            column = current[1];
            minMax = Math.min(current[2], A[row][column]);

            if (minMax <= memo[row][column])
            {
                continue;
            }
            memo[row][column] = minMax;

            for (int[] step : steps)
            {
                nextRow = row + step[0];
                nextColumn = column + step[1];
                if (nextRow < 0 || nextRow == rows || nextColumn < 0 || nextColumn == columns)
                {
                    continue;
                }

                queue.add(new int[]{nextRow, nextColumn, minMax});
            }
        }

        return memo[rows - 1][columns - 1];
    }

    public static void main(String[] args)
    {
        PathWithMaximumMinimumValue clazz = new PathWithMaximumMinimumValue();
        System.out.println(clazz.maximumMinimumPath(new int[][]
                {
                        {5, 4, 5},
                        {1, 2, 6},
                        {7, 4, 6}
                }));
    }
}
