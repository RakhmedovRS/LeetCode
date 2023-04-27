package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/26/2023
 */
@LeetCode(
        id = 2653,
        name = "Sliding Subarray Beauty",
        url = "https://leetcode.com/problems/sliding-subarray-beauty/",
        difficulty = Difficulty.MEDIUM
)
public class SlidingSubarrayBeauty
{
    public int[] getSubarrayBeauty(int[] nums, int k, int x)
    {
        int[] num = new int[102];

        int[] ans = new int[nums.length - k + 1];
        int pos = 0;
        for (int left = 0, right = 0; right < nums.length; )
        {
            num[nums[right++] + 50]++;
            if (right == k)
            {
                ans[pos++] = get(num, x);
            }
            else if (right > k)
            {
                num[nums[left++] + 50]--;
                ans[pos++] = get(num, x);
            }
        }
        return ans;
    }

    private int get(int[] nums, int x)
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (i < 51)
            {
                x -= nums[i];
                if (x <= 0)
                {
                    return i - 50;
                }
            }
        }

        return 0;
    }
}
