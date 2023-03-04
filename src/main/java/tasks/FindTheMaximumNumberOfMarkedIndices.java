package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 3/1/2023
 */
@LeetCode(
        id = 2576,
        name = "Find the Maximum Number of Marked Indices",
        url = "https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/",
        difficulty = Difficulty.MEDIUM
)
public class FindTheMaximumNumberOfMarkedIndices
{
    public int maxNumOfMarkedIndices(int[] nums)
    {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int answer = 0;
        for (int i = nums.length / 2 - 1; i >= 0; i--)
        {
            int num = nums[i];
            Integer c = map.remove(num);
            if (c == null)
            {
                continue;
            }

            if (--c > 0)
            {
                map.put(num, c);
            }

            Integer ceil = map.ceilingKey(num * 2);
            if (ceil != null)
            {
                c = map.remove(ceil);
                if (--c > 0)
                {
                    map.put(ceil, c);
                }

                answer+= 2;
            }
        }

        return answer;
    }
}
