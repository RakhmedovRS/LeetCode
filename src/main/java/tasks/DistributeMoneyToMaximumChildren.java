package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 3/18/2023
 */
@LeetCode(
        id = 2591,
        name = "Distribute Money to Maximum Children",
        url = "https://leetcode.com/problems/distribute-money-to-maximum-children/description/",
        difficulty = Difficulty.EASY
)
public class DistributeMoneyToMaximumChildren
{
    public int distMoney(int money, int children)
    {
        if (money < children)
        {
            return -1;
        }

        money -= children;
        int[] child = new int[children];
        Arrays.fill(child, 1);

        int count = 0;
        int pos = 0;
        while (money > 0)
        {
            if (child[pos] < 8)
            {
                int diff = Math.max(8 - child[pos], 8 - money);
                diff = Math.min(diff, money);
                child[pos] += diff;
                money -= diff;
                if (child[pos] == 8)
                {
                    count++;
                }
            }
            else
            {
                if (child[pos] == 8)
                {
                    count--;
                }
                child[pos] += money;
                money = 0;
            }

            if (child[pos] == 4)
            {
                int nextPos = (pos + 1) % child.length;
                if (child[nextPos] == 8)
                {
                    count--;
                }
                child[nextPos]--;
                child[pos] += money + 1;
                money = 0;
            }

            pos++;
            pos %= child.length;
        }

        for (int num : child)
        {
            if (num != 4)
            {
                return count;
            }
        }

        return -1;
    }
}
