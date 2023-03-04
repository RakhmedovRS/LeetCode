package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 1/17/2023
 */
@LeetCode(
        id = 2537,
        name = "Count the Number of Good Subarrays",
        url = "https://leetcode.com/problems/count-the-number-of-good-subarrays/",
        difficulty = Difficulty.MEDIUM
)
public class CountTheNumberOfGoodSubarrays
{
    public long countGood(int[] nums, int k)
    {
        long count = 0L;
        int left = 0;
        int right = 0;
        long pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (left < nums.length)
        {
            if (right >= nums.length && pairs < k)
            {
                break;
            }

            if (pairs < k && right < nums.length)
            {
                if (map.containsKey(nums[right]))
                {
                    int curr = map.get(nums[right]);
                    int p = (curr * (curr - 1)) / 2;
                    pairs -= p;

                    p = (curr * (curr + 1)) / 2;
                    pairs += p;

                    map.put(nums[right], curr + 1);
                }
                else
                {
                    map.put(nums[right], 1);
                }
                right++;
            }
            else
            {
                count += (nums.length - (right - 1));

                int curr = map.get(nums[left]);
                int p = (curr * (curr - 1)) / 2;
                pairs -= p;

                curr--;
                p = (curr * (curr - 1)) / 2;
                pairs += p;

                map.put(nums[left], curr);

                left++;
            }
        }

        return count;
    }
}
