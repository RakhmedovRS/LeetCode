package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

@LeetCode(
        id = 2706,
        name = "Buy Two Chocolates",
        url = "https://leetcode.com/problems/buy-two-chocolates/",
        difficulty = Difficulty.EASY
)
public class BuyTwoChocolates
{
    public int buyChoco(int[] prices, int money)
    {
        int left = money;
        Arrays.sort(prices);
        left -= prices[0];
        left -= prices[1];
        if(left < 0)
        {
            return money;
        }

        return left;
    }
}
