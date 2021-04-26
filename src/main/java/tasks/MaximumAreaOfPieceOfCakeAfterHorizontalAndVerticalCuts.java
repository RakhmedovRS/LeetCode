package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 10.03.2021
 */
@LeetCode(
        id = 1465,
        name = "Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts",
        url = "https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts
{
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts)
    {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++)
        {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        int maxV = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++)
        {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int)(((long) maxH * maxV) % 1_000_000_007);
    }
}
