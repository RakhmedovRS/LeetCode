package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-01
 */
@LeetCode(
        id = 3858,
        name = "Minimum Bitwise OR From Grid",
        url = "https://leetcode.com/problems/minimum-bitwise-or-from-grid/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumBitwiseORFromGrid {
    public int minimumOR(int[][] grid) {
        int ans = 0;
        for (int bit = 30; bit >= 0; bit--) {
            boolean hasToUseBit = false;
            int target = ans | (1 << bit);
            for (int[] row : grid) {

                boolean hasNoBit = false;
                for (int num : row) {
                    if ((num | ans) < target) {
                        hasNoBit = true;
                        break;
                    }
                }

                if (!hasNoBit) {
                    hasToUseBit = true;
                    break;
                }
            }

            if (hasToUseBit) {
                ans |= (1 << bit);
            }
        }

        return ans;
    }
}