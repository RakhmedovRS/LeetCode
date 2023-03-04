package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 11/3/2022
 */
@LeetCode(
        id = 2457,
        name = "Minimum Addition to Make Integer Beautiful",
        url = "https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumAdditionToMakeIntegerBeautiful
{
    public long makeIntegerBeautiful(long n, int target)
    {
        int sum = sum(n);
        LinkedList<Long> list = new LinkedList<>();
        while (n > 0)
        {
            list.addFirst(n % 10);
            n /= 10;
        }

        LinkedList<Long> vals = new LinkedList<>();
        int rem = 0;
        while (sum > target)
        {
            long v = list.removeLast() + rem;
            rem = 0;
            sum -= v;
            sum += 1;
            rem += 1;
            vals.addLast(10L - v);
        }

        long answer = 0;
        while (!vals.isEmpty())
        {
            answer *= 10;
            answer += vals.removeLast();
        }

        return answer;
    }

    public int sum(long n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
