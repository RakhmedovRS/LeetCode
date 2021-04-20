package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 18.02.2021
 */
@LeetCode(
        id = 413,
        name = "Arithmetic Slices",
        url = "https://leetcode.com/problems/arithmetic-slices/",
        difficulty = Difficulty.MEDIUM
)
public class ArithmeticSlices
{
    public int numberOfArithmeticSlices(int[] A)
    {
        int count = 0;
        if (A.length < 3)
        {
            return count;
        }

        int diff;
        int left = 0;
        int right = 1;
        int max;
        while (left < A.length - 2)
        {
            max = 0;
            diff = A[right] - A[left];
            int prev = left;
            int current = right;
            while (current < A.length)
            {
                if (diff == A[current] - A[prev])
                {
                    max = 1 + current - left;
                    prev++;
                    current++;
                }
                else
                {
                    if (max >= 3)
                    {
                        count += ((max - 2) * (max - 1)) / 2;
                    }
                    left = prev;
                    max = 0;
                    break;
                }
            }

            if (max >= 3)
            {
                count += ((max - 2) * (max - 1)) / 2;
            }

            left = prev;
            right = prev + 1;
        }

        return count;
    }
}
