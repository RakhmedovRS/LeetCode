package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-21
 */
@LeetCode(
        id = 3296,
        name = "Minimum Number of Seconds to Make Mountain Height Zero",
        url = "https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfSecondsToMakeMountainHeightZero {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long max = 0;
        Map<Integer, Long> sum = new HashMap<>();
        for (int i = 0; i < workerTimes.length; i++) {
            sum.put(i, (long) workerTimes[i]);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            long A = a[2] + (1 + a[1]) * sum.get((int) a[0]);
            long B = b[2] + (1 + b[1]) * sum.get((int) b[0]);
            if (A == B) {
                return Long.compare(sum.get((int) a[0]), sum.get((int) b[0]));
            }
            return Long.compare(A, B);
        });
        for (int i = 0; i < workerTimes.length; i++) {
            pq.offer(new long[]{i, 0, 0});
        }

        while (mountainHeight-- > 0) {
            long[] curr = pq.remove();
            curr[1]++;
            curr[2] += sum.get((int) curr[0]) * curr[1];
            max = Math.max(max, curr[2]);
            pq.add(curr);
        }

        return max;
    }
}