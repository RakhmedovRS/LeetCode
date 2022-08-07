package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 8/7/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2363,
        name = "Merge Similar Items",
        url = "https://leetcode.com/problems/merge-similar-items/",
        difficulty = Difficulty.EASY
)
public class MergeSimilarItems
{
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2)
    {
        int[] memo = new int[1001];
        for (int[] item : items1)
        {
            memo[item[0]] += item[1];
        }

        for (int[] item : items2)
        {
            memo[item[0]] += item[1];
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < memo.length; i++)
        {
            if (memo[i] > 0)
            {
                lists.add(Arrays.asList(i, memo[i]));
            }
        }


        return lists;
    }
}
