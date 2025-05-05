package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-04
 */
@LeetCode(
        id = 3536,
        name = "Maximum Product of Two Digits",
        url = "https://leetcode.com/problems/maximum-product-of-two-digits/description/",
        difficulty = Difficulty.EASY
)
public class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        list.sort(null);
        return list.get(list.size() - 1) * list.get(list.size() - 2);
    }
}