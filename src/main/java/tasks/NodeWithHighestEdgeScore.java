package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/16/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2374,
        name = "Node With Highest Edge Score",
        url = "https://leetcode.com/problems/node-with-highest-edge-score/",
        difficulty = Difficulty.MEDIUM
)
public class NodeWithHighestEdgeScore
{
    public int edgeScore(int[] edges)
    {
        long[] sum = new long[edges.length];

        for (int i = 0; i < edges.length; i++)
        {
            sum[edges[i]] += i;
        }

        long max = 0;
        int maxPos = 0;

        for (int i = 0; i < sum.length; i++)
        {
            if (sum[i] > max)
            {
                max = sum[i];
                maxPos = i;
            }
        }

        return maxPos;
    }
}
