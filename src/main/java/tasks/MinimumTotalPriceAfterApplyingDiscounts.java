package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-08-09
 */
@LeetCode(
        id = 4014,
        name = "Minimum Total Price After Applying Discounts",
        url = "https://leetcode.com/problems/minimum-total-price-after-applying-discounts/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumTotalPriceAfterApplyingDiscounts {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int d = discounts.length - 1;
        double res = 0D;
        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            if (d >= 0) {
                res += (double) (price * (100 - discounts[d--])) / 100;
            } else {
                res += price;
            }
        }

        return res;
    }
}