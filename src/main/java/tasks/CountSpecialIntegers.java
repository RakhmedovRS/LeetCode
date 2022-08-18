package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/18/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2376,
        name = "Count Special Integers",
        url = "https://leetcode.com/problems/count-special-integers/",
        difficulty = Difficulty.HARD
)
public class CountSpecialIntegers
{
    public int countSpecialNumbers(int n)
    {
        String val  = "" + n;
        int len = val.length() - 1;
        int count;
        if (len == 0)
        {
            count = 0;
        }
        else
        {
            count = 9;
        }

        if (len > 1)
        {
            int unique = 9;
            for (int i = 1; i < len; i++)
            {
                unique *= (10 - i);
                count += unique;
            }
        }

        int number = 0;
        for (int i = 0; i < len; i++)
        {
            number *= 10;
            number += 9;
        }

        outer: while (number++ < n)
        {
            int used = 1 << 11;
            int temp = number;
            while (temp > 0)
            {
                int digit = temp % 10;
                temp /= 10;
                if ((used & (1 << digit)) > 0)
                {
                    continue outer;
                }

                used ^= (1 << digit);
            }

            count++;
        }

        return count;
    }
}
