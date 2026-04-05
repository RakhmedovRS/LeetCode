package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-04
 */
@LeetCode(
        id = 3890,
        name = "Integers With Multiple Sum of Two Cubes",
        url = "https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/description/",
        difficulty = Difficulty.MEDIUM
)
public class IntegersWithMultipleSumOfTwoCubes {
    public List<Integer> findGoodIntegers(int n) {
        List<Long> vals = new ArrayList<>();
        long val = 1;
        while (Math.pow(val, 3) <= n) {
            vals.add((long) Math.pow(val++, 3));
        }

        Map<Integer, Integer> memo = new HashMap<>();
        outer:
        for (int i = 0; i < vals.size(); i++) {
            for (int j = i + 1; j < vals.size(); j++) {
                if (vals.get(i) + vals.get(j) > n) {
                    continue outer;
                }

                int res = (int) (vals.get(i) + vals.get(j));
                memo.put(res, memo.getOrDefault(res, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        memo.forEach((key, value) -> {
            if (value >= 2) {
                ans.add(key);
            }
        });

        ans.sort(null);

        return ans;
    }
}