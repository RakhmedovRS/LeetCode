package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/19/2022
 */
@LeetCode(
        id = 2443,
        name = "Sum of Number and Its Reverse",
        url = "https://leetcode.com/problems/sum-of-number-and-its-reverse/",
        difficulty = Difficulty.MEDIUM
)
public class SumOfNumberAndItsReverse
{
    public boolean sumOfNumberAndReverse(int num)
    {
        for (int i = 0; i <= num; i++)
        {
            if (num == (i + reverse(i)))
            {
                return true;
            }
        }

        return false;
    }

    public int reverse(int x)
    {
        long value = 0;
        while (x != 0)
        {
            value *= 10;
            value += x % 10;
            x /= 10;
        }

        if (Math.abs(value) > Integer.MAX_VALUE)
        {
            return 0;
        }

        return (int) (value);
    }
}
