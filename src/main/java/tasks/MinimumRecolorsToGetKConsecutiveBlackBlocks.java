package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/20/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2379,
        name = "Minimum Recolors to Get K Consecutive Black Blocks",
        url = "https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/",
        difficulty = Difficulty.EASY
)
public class MinimumRecolorsToGetKConsecutiveBlackBlocks
{
    public int minimumRecolors(String blocks, int k)
    {
        int recolor = k;
        int current = 0;
        for (int left = 0, right = 0; right < blocks.length(); right++)
        {
            current += blocks.charAt(right) == 'B' ? 1 : 0;
            if (right - left == k)
            {
                current -= blocks.charAt(left++) == 'B' ? 1 : 0;
                recolor = Math.min(recolor, Math.max(0, k - current));
            }
            else if (right - left == k - 1)
            {
                recolor = Math.min(recolor, Math.max(0, k - current));
            }
        }

        return recolor;
    }
}
