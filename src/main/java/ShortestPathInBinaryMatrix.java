import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
@LeetCode(
        id = 1091,
        name = "Shortest Path in Binary Matrix",
        url = "https://leetcode.com/problems/shortest-path-in-binary-matrix/",
        difficulty = Difficulty.MEDIUM
)
public class ShortestPathInBinaryMatrix
{
    public int shortestPathBinaryMatrix(int[][] grid)
    {
        int rows = grid.length;
        int columns = grid[0].length;
        if (grid[0][0] == 1)
        {
            return -1;
        }

        int[][] memo = new int[rows][columns];
        for (int[] row : memo)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        int[] current;
        int row;
        int column;
        int nextRow;
        int nextColumn;
        int path;
        while (!queue.isEmpty())
        {
            current = queue.remove();
            row = current[0];
            column = current[1];
            path = current[2];

            if (path >= memo[row][column])
            {
                continue;
            }

            memo[row][column] = path;

            for (int r = -1; r <= 1; r++)
            {
                for (int c = -1; c <= 1; c++)
                {
                    if (r == 0 && c == 0)
                    {
                        continue;
                    }

                    nextRow = row + r;
                    nextColumn = column + c;
                    if (nextRow >= 0
                            && nextRow < rows
                            && nextColumn >= 0
                            && nextColumn < columns
                            && path + 1 < memo[nextRow][nextColumn]
                            && grid[nextRow][nextColumn] == 0
                    )
                    {
                        queue.add(new int[]{nextRow, nextColumn, path + 1});
                    }
                }
            }
        }

        return memo[rows - 1][columns - 1] == Integer.MAX_VALUE ? -1 : memo[rows - 1][columns - 1];
    }
}
