package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 1/23/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2545,
        name = "Sort the Students by Their Kth Score",
        url = "https://leetcode.com/problems/sort-the-students-by-their-kth-score/",
        difficulty = Difficulty.MEDIUM
)
public class SortTheStudentsByTheirKthScore
{
    public int[][] sortTheStudents(int[][] score, int k) {
        List<int[]> list = new ArrayList<>(Arrays.asList(score));
        list.sort((a, b) -> b[k] - a[k]);

        int[][] res = new int[list.size()][];
        for (int i = 0 ; i < list.size(); i++)
        {
            res[i] = list.get(i);
        }

        return res;
    }
}
