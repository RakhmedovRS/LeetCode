package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2/5/2023
 */
@LeetCode(
        id = 2558,
        name = "Take Gifts From the Richest Pile",
        url = "https://leetcode.com/problems/take-gifts-from-the-richest-pile/",
        difficulty = Difficulty.EASY
)
public class TakeGiftsFromTheRichestPile
{
    public long pickGifts(int[] gifts, int k)
    {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int g: gifts)
        {
            pq.add(g);
        }

        for (int i = 0; i < k; i++)
        {
            int val = pq.remove();
            val = (int)Math.sqrt(val);
            pq.add(val);
        }

        while (!pq.isEmpty())
        {
            res += pq.remove();
        }

        return res;
    }
}
