package tasks;
import common.Difficulty;
import common.LeetCode;
import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-06-07
 */
@LeetCode(
id = 3954,
 name = "Sum of Compatible Numbers in Range I",
 url = "https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/description/",
 difficulty = Difficulty.EASY
)
public class SumOfCompatibleNumbersInRangeI {
    public int sumOfGoodIntegers(int n, int k) {
        int ans = 0;
        for (int i = 1; i <= 1000; i++) {
            if (Math.abs(n - i) <= k && (n & i) == 0) {
                ans += i;
            }
        }
        return ans;
    }
}