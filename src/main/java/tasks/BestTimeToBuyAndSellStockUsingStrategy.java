package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-16
 */
@LeetCode(
        id = 3652,
        name = "Best Time to Buy and Sell Stock using Strategy",
        url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/description/",
        difficulty = Difficulty.MEDIUM
)
public class BestTimeToBuyAndSellStockUsingStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long max = 0;
        long profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (strategy[i] == -1) {
                profit -= (prices[i]);
            } else if (strategy[i] == 1) {
                profit += prices[i];
            }
        }
        max = profit;
        int a = 0;
        int b = k / 2 - 1;
        int c = k / 2;
        int d = k - 1;
        for (int i = 0; i <= d; i++) {
            if (a <= i && i <= b) {
                if (strategy[i] == -1) {
                    profit += (prices[i]);
                } else if (strategy[i] == 1) {
                    profit -= prices[i];
                }
            }

            if (c <= i && i <= d) {
                if (strategy[i] == -1) {
                    profit += (2L * prices[i]);
                } else if (strategy[i] == 0) {
                    profit += prices[i];
                }
            }
        }
        max = Math.max(max, profit);

        while (d < prices.length - 1) {
            if (a != b) {
                if (strategy[a] == -1) {
                    profit -= (prices[a]);
                } else if (strategy[a] == 1) {
                    profit += prices[a];
                }
                a++;
                b++;
                if (strategy[b] == -1) {
                    profit += (prices[b]);
                } else if (strategy[b] == 1) {
                    profit -= prices[b];
                }
            } else {
                if (strategy[a] == -1) {
                    profit -= (prices[a]);
                } else if (strategy[a] == 1) {
                    profit += prices[a];
                }
                a++;
                b++;
                if (strategy[a] == -1) {
                    profit += (prices[a]);
                } else if (strategy[a] == 1) {
                    profit -= prices[a];
                }
            }

            if (c != d) {
                if (strategy[c] == -1) {
                    profit -= (2L * prices[c]);
                } else if (strategy[c] == 0) {
                    profit -= prices[c];
                }
                c++;
                d++;
                if (strategy[d] == -1) {
                    profit += (2L * prices[d]);
                } else if (strategy[d] == 0) {
                    profit += prices[d];
                }
            } else {
                if (strategy[c] == -1) {
                    profit -= (2L * prices[c]);
                } else if (strategy[c] == 0) {
                    profit -= prices[c];
                }
                c++;
                d++;
                if (strategy[c] == -1) {
                    profit += (2L * prices[c]);
                } else if (strategy[c] == 0) {
                    profit += prices[c];
                }
            }

            max = Math.max(max, profit);
        }

        return max;
    }
}