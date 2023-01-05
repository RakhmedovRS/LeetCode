package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 1/4/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2523,
        name = "Closest Prime Numbers in Range",
        url = "https://leetcode.com/problems/closest-prime-numbers-in-range/",
        difficulty = Difficulty.MEDIUM
)
public class ClosestPrimeNumbersInRange
{
    public int[] closestPrimes(int left, int right)
    {
        boolean[] primes = new boolean[right + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= right; i++)
        {
            if (primes[i])
            {
                for (int j = i * i; j <= right; j += i)
                {
                    primes[j] = false;
                }
            }
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 2; i < primes.length; i++)
        {
            if (primes[i])
            {
                treeSet.add(i);
            }
        }


        int diff = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        Integer prev = null;
        for (int val : treeSet.subSet(left, true, right, true))
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
