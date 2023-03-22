package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/21/2023
 */
@LeetCode(
        id = 2594,
        name = "Minimum Time to Repair Cars",
        url = "https://leetcode.com/problems/minimum-time-to-repair-cars/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumTimeToRepairCars
{
    public long repairCars(int[] ranks, int cars)
    {
        long left = 0;
        long right = Long.MAX_VALUE;
        long mid;
        long res = 0;
        while (left <= right)
        {
            mid = (right - left) / 2 + left;
            if (canRepair(ranks, cars, mid))
            {
                right = mid - 1;
                res = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return res;
    }

    boolean canRepair(int[] ranks, int cars, long time)
    {
        for (int i = 0; i < ranks.length; i++)
        {
            if (cars <= 0)
            {
                break;
            }
            long left = 0;
            long right = cars;
            long mid;
            long cand = 0;
            while (left <= right)
            {
                mid = (left + right) / 2;
                if (ranks[i] * (long) Math.pow(mid, 2) <= time)
                {
                    cand = mid;
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }

            cars -= cand;
        }

        return cars <= 0;
    }
}
