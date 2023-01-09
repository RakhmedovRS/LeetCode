package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 1/9/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2530,
        name = "Maximal Score After Applying K Operations",
        url = "https://leetcode.com/problems/maximal-score-after-applying-k-operations/",
        difficulty = Difficulty.MEDIUM
)
public class MaximalScoreAfterApplyingKOperations
{
    public long maxKelements(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums)
        {
            pq.add(num);
        }

        long score = 0;
        while (k-- > 0)
        {
            int n = pq.remove();
            score += n;
            if (n % 3 == 0)
            {
                pq.add(n/3);
            }
            else
            {
                pq.add(1+ n/3);
            }
        }

        return score;
    }
}
