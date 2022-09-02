package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 9/2/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2389,
        name = "Longest Subsequence With Limited Sum",
        url = "https://leetcode.com/problems/longest-subsequence-with-limited-sum/",
        difficulty = Difficulty.EASY
)
public class LongestSubsequenceWithLimitedSum
{
    public int[] answerQueries(int[] nums, int[] queries)
    {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
        {
            nums[i] += nums[i - 1];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                if (nums[j] > queries[i])
                {
                    answer[i] = j;
                    break;
                }

                if (j == nums.length - 1)
                {
                    answer[i] = nums.length;
                }
            }
        }

        return answer;
    }
}
