package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 10/16/2022
 */
@LeetCode(
        id = 2438,
        name = "Range Product Queries of Powers",
        url = "https://leetcode.com/problems/range-product-queries-of-powers/",
        difficulty = Difficulty.MEDIUM
)
public class RangeProductQueriesOfPowers
{
    int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries)
    {
        List<Integer> powers = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        while (n > 0)
        {
            p.add(n % 2);
            n /= 2;
        }

        for (int i = 0; i < p.size(); i++)
        {
            if (p.get(i) == 1)
            {
                powers.add((int) Math.pow(2, i));
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            long product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++)
            {
                product = (product * powers.get(j)) % MOD;
            }

            answer[i] = (int) product;
        }

        return answer;
    }
}
