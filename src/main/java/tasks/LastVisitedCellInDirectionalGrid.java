package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-18
 */
@LeetCode(
        id = 4084,
        name = "Last Visited Cell in a Directional Grid",
        url = "https://leetcode.com/problems/last-visited-cell-in-a-directional-grid/description/",
        difficulty = Difficulty.MEDIUM
)
public class LastVisitedCellInDirectionalGrid {
    public int[] lastVisitedCell(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Boolean[][] visited = new Boolean[rows][columns];
        int[] ans = new int[]{0, 0};
        int row = 0;
        int column = 0;
        while (row >= 0 && row < rows && column >= 0 && column < columns) {
            if (visited[row][column] != null && visited[row][column]) {
                break;
            }
            visited[row][column] = true;
            ans[0] = row;
            ans[1] = column;

            if (grid[row][column] == 'L') {
                column--;
            } else if (grid[row][column] == 'R') {
                column++;
            } else if (grid[row][column] == 'U') {
                row--;
            } else {
                row++;
            }
        }

        return ans;
    }
}