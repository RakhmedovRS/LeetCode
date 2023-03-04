package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/26/2022
 */
@LeetCode(
        id = 2515,
        name = "Shortest Distance to Target String in a Circular Array",
        url = "https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/",
        difficulty = Difficulty.EASY
)
public class ShortestDistanceToTargetStringInCircularArray
{
    public int closetTarget(String[] words, String target, int startIndex)
    {
        int pos = Integer.MAX_VALUE;
        for (int i = startIndex, step = 0; i < words.length * 2; i++, step++)
        {
            if (words[i % words.length].equals(target))
            {
                pos = Math.min(pos, step);
            }
        }

        for (int i = startIndex, step = 0; step < words.length; step++, i--)
        {
            if (i < 0)
            {
                i = words.length - 1;
            }

            if (words[i].equals(target))
            {
                pos = Math.min(pos, step);
            }
        }

        return pos == Integer.MAX_VALUE ? -1 : pos;
    }
}
