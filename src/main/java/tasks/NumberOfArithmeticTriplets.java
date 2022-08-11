package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 8/11/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2367,
        name = "Number of Arithmetic Triplets",
        url = "https://leetcode.com/problems/number-of-arithmetic-triplets/",
        difficulty = Difficulty.EASY
)
public class NumberOfArithmeticTriplets
{
    public int arithmeticTriplets(int[] nums, int diff)
    {
        int count = 0;
        for (int num: nums)
        {
            if (Arrays.binarySearch(nums, num + diff) > 0 && Arrays.binarySearch(nums, num + diff * 2) > 0)
            {
                count++;
            }
        }

        return count;
    }
}
