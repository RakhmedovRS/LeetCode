package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 10/17/2022
 */
@LeetCode(
        id = 2441,
        name = "Largest Positive Integer That Exists With Its Negative",
        url = "https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/",
        difficulty = Difficulty.EASY
)
public class LargestPositiveIntegerThatExistsWithItsNegative
{
    public int findMaxK(int[] nums)
    {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num: nums)
        {
            set.add(num);
        }

        int max = -1;
        for (Integer val: set)
        {
            if (val > 0 && set.contains(-val))
            {
                max = Math.max(max, val);
            }
        }

        return max;
    }
}
