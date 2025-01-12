package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-01-11
 */
@LeetCode(
        id = 3417,
        name = "Zigzag Grid Traversal With Skip",
        url = "https://leetcode.com/problems/zigzag-grid-traversal-with-skip/description/",
        difficulty = Difficulty.EASY
)
public class ZigzagGridTraversalWithSkip {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        boolean take = true;
        boolean leftToR = take;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int row = 0; row < rows; row++) {
            if (leftToR) {
                for (int column = 0; column < columns; column++) {
                    if (take) {
                        ans.add(grid[row][column]);
                    }

                    take = !take;
                }
            } else {
                for (int column = columns - 1; column >= 0; column--) {
                    if (take) {
                        ans.add(grid[row][column]);
                    }

                    take = !take;
                }
            }

            leftToR = !leftToR;
        }
        return ans;
    }
}