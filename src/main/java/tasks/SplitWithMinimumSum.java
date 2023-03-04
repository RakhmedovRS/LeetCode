package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 3/4/2023
 */
@LeetCode(
        id = 2578,
        name = "Split With Minimum Sum",
        url = "https://leetcode.com/problems/split-with-minimum-sum/",
        difficulty = Difficulty.EASY
)
public class SplitWithMinimumSum
{
    public int splitNum(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        while (num > 0)
        {
            list.add(num % 10);
            num /= 10;
        }

        list.sort(null);

        int a = 0;
        int b = 0;
        while (!list.isEmpty())
        {
            a *= 10;
            a += list.removeFirst();
            if (!list.isEmpty())
            {
                b *= 10;
                b += list.removeFirst();
            }
        }

        return a + b;
    }
}
