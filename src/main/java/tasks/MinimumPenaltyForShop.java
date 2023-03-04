package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/28/2022
 */
@LeetCode(
        id = 2483,
        name = "Minimum Penalty for a Shop",
        url = "https://leetcode.com/problems/minimum-penalty-for-a-shop/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumPenaltyForShop
{
    public int bestClosingTime(String customers)
    {
        char[] chars = customers.toCharArray();
        int[] leftToRight = new int[customers.length()];
        for (int i = 0; i < leftToRight.length; i++)
        {
            if (i > 0)
            {
                leftToRight[i] += leftToRight[i - 1];
            }

            if (chars[i] == 'N')
            {
                leftToRight[i]++;
            }
        }

        int[] rightToLeft = new int[customers.length()];
        for (int i = rightToLeft.length - 1; i >= 0; i--)
        {
            if (i + 1 < rightToLeft.length)
            {
                rightToLeft[i] += rightToLeft[i + 1];
            }

            if (chars[i] == 'Y')
            {
                rightToLeft[i]++;
            }
        }

        int bestPos = 0;
        int diff = rightToLeft[0];
        for (int i = 0; i <= customers.length(); i++)
        {
            int curr = 0;
            if (i - 1 >= 0)
            {
                curr += leftToRight[i - 1];
            }

            if (i + 1 < customers.length())
            {
                curr += rightToLeft[i + 1];
            }

            if (curr < diff)
            {
                bestPos = i + 1;
                diff = curr;
            }
        }

        return bestPos;
    }
}
