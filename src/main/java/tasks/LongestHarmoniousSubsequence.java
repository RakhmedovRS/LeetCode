package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 06-Jul-20
 */
@LeetCode(
        id = 594,
        name = "Longest Harmonious Subsequence",
        url = "https://leetcode.com/problems/longest-harmonious-subsequence/",
        difficulty = Difficulty.EASY
)
public class LongestHarmoniousSubsequence
{
    public int findLHS(int[] nums)
    {
        if (nums.length <= 1)
        {
            return 0;
        }

        Arrays.sort(nums);
        int lhs = 0;
        int candidate;
        for (int i = 0; i < nums.length; i++)
        {
            candidate = binarySearch(nums, nums[i] + 1);
            if (candidate != -1)
            {
                lhs = Math.max(lhs, 1 + candidate - i);
            }
        }

        return lhs;
    }

    private int binarySearch(int[] nums, int value)
    {
        int candidate = -1;
        int left = 0;
        int mid;
        int right = nums.length - 1;
        while (left <= right)
        {
            mid = (left + right) / 2;
            if (nums[mid] == value)
            {
                candidate = mid;
                left = mid + 1;
            }
            else if (nums[mid] < value)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return candidate;
    }
}
