package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-09-05
 */
@LeetCode(
        id = 4039,
        name = "Sum of Decoded Numbers",
        url = "https://leetcode.com/problems/sum-of-decoded-numbers/description/",
        difficulty = Difficulty.MEDIUM
)
public class SumOfDecodedNumbers {
    int MOD = 1_000_000_007;

    public int sumDecoded(long[] nums) {
        long ans = 0L;
        for (long num : nums) {
            long w = num % 10;
            long d = num / 10;
            long x = 0;
            long y = 0;
            char[] digits = ("" + d).toCharArray();
            for (int i = 0; i < digits.length; i++) {
                if (w > 0) {
                    x *= 10;
                    x += (digits[i] - '0');
                    w--;
                } else {
                    y *= 10;
                    y += (digits[i] - '0');
                }
            }

            ans += powerMod(x, y, MOD);
            ans %= MOD;
        }

        return (int) (ans % MOD);
    }

    public static long powerMod(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = base * base % mod;
        }
        return result < 0 ? result + mod : result;
    }
}