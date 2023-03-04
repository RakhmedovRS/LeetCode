package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2/20/2023
 */
@LeetCode(
        id = 2568,
        name = "Minimum Impossible OR",
        url = "https://leetcode.com/problems/minimum-impossible-or/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumImpossibleOR
{
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
        {
            set.add(num);
        }

        int num = 1;
        while (set.contains(num))
        {
            num <<= 1;
        }

        return num;
    }
}
