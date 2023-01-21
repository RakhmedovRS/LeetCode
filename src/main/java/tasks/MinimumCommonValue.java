package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 1/21/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2540,
        name = "Minimum Common Value",
        url = "https://leetcode.com/problems/minimum-common-value/",
        difficulty = Difficulty.EASY
)
public class MinimumCommonValue
{
    public int getCommon(int[] nums1, int[] nums2)
    {
        Set<Integer> set = new HashSet<>();
        for (int num: nums1)
        {
            set.add(num);
        }

        for (int num: nums2)
        {
            if (set.contains(num))
            {
                return num;
            }
        }

        return -1;
    }
}
