package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/3/2022
 */
@LeetCode(
        id = 2425,
        name = "Bitwise XOR of All Pairings",
        url = "https://leetcode.com/problems/bitwise-xor-of-all-pairings/",
        difficulty = Difficulty.MEDIUM
)
public class BitwiseXOROfAllPairings
{
    public int xorAllNums(int[] nums1, int[] nums2)
    {
        int xorNum1 = nums1[0];
        for (int i = 1; i < nums1.length; i++)
        {
            xorNum1 ^= nums1[i];
        }

        int xorNum2 = nums2[0];
        for (int i = 1; i < nums2.length; i++)
        {
            xorNum2 ^= nums2[i];
        }

        if (nums1.length % 2 == 0)
        {
            if (nums2.length % 2 == 0)
            {
                return 0;
            }
            return xorNum1;
        }
        else if (nums2.length % 2 == 0)
        {
            if (nums1.length % 2 == 0)
            {
                return 0;
            }
            return xorNum2;
        }

        return xorNum1 ^ xorNum2;
    }
}
