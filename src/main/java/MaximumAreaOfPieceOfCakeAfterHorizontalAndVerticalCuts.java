import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
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
        List<Integer> vertical = new ArrayList<>();
        vertical.add(0);
        vertical.add(w);
        for (int cut : verticalCuts)
        {
            vertical.add(cut);
        }

        List<Integer> horizontal = new ArrayList<>();
        horizontal.add(0);
        horizontal.add(h);
        for (int cut : horizontalCuts)
        {
            horizontal.add(cut);
        }

        vertical.sort(Comparator.naturalOrder());
        horizontal.sort(Comparator.naturalOrder());

        int maxH = 0;
        for (int i = 1; i < horizontal.size(); i++)
        {
            maxH = Math.max(maxH, horizontal.get(i) - horizontal.get(i - 1));
        }

        int maxV = 0;
        for (int i = 1; i < vertical.size(); i++)
        {
            maxV = Math.max(maxV, vertical.get(i) - vertical.get(i - 1));
        }

        return (int)(((long) maxH * maxV) % 1_000_000_007);
    }
}
