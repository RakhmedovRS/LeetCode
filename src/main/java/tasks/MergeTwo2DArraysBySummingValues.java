package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 2/21/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2570,
        name = "Merge Two 2D Arrays by Summing Values",
        url = "https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/",
        difficulty = Difficulty.EASY
)
public class MergeTwo2DArraysBySummingValues
{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : nums1)
        {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        for (int[] ints : nums2)
        {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        int[][] res = new int[map.size()][];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            res[pos++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return res;
    }
}
