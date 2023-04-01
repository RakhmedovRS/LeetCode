package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 4/1/2023
 */
@LeetCode(
        id = 2605,
        name = "Form Smallest Number From Two Digit Arrays",
        url = "https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/",
        difficulty = Difficulty.EASY
)
public class FormSmallestNumberFromTwoDigitArrays
{
    public int minNumber(int[] nums1, int[] nums2)
    {
        TreeSet<Integer> set1 = new TreeSet<>();
        for (int num : nums1)
        {
            set1.add(num);
        }

        TreeSet<Integer> set2 = new TreeSet<>();
        for (int num : nums2)
        {
            set2.add(num);
        }

        int min = Integer.MAX_VALUE;
        for (int val1: set1)
        {
            for (int val2: set2)
            {
                if (val1 == val2)
                {
                    min = Math.min(min, val1);
                }

                min = Math.min(min, val1 * 10 + val2);
            }
        }

        for (int val1: set2)
        {
            for (int val2: set1)
            {
                if (val1 == val2)
                {
                    min = Math.min(min, val1);
                }

                min = Math.min(min, val1 * 10 + val2);
            }
        }

        return min;
    }
}
