package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 11/12/2022
 */
@LeetCode(
        id = 2465,
        name = "Number of Distinct Averages",
        url = "https://leetcode.com/problems/number-of-distinct-averages/",
        difficulty = Difficulty.EASY
)
public class NumberOfDistinctAverages
{
    public int distinctAverages(int[] nums)
    {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        for (int left = 0, right = nums.length - 1; left < right; left++, right--)
        {
            set.add((((double)nums[left]) + nums[right]) /2 );
        }

        return set.size();
    }
}
