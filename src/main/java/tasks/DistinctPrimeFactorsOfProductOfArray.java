package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 1/2/2023
 */
@LeetCode(
        id = 2521,
        name = "Distinct Prime Factors of Product of Array",
        url = "https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/",
        difficulty = Difficulty.MEDIUM
)
public class DistinctPrimeFactorsOfProductOfArray
{
    public int[] closestPrimes(int left, int right)
    {
        TreeSet<Integer> primes = new TreeSet<>(Arrays.asList(2, 3, 5, 7, 11));
        outer:
        for (int i = 12; i <= right; i++)
        {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
            {
                continue;
            }

            for (int prime : primes)
            {
                if (prime % i == 0 || i % prime == 0)
                {
                    continue outer;
                }
            }

            primes.add(i);
        }

        int diff = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        Integer prev = null;
        for (int val : primes.subSet(left, true, right, true))
        {
            if (prev != null)
            {
                if (val - prev < diff)
                {
                    diff = val - prev;
                    l = prev;
                    r = val;
                }
            }

            prev = val;
        }

        return new int[]{l, r};
    }
}
