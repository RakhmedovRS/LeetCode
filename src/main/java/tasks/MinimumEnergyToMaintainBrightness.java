package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-06-07
 */
@LeetCode(
        id = 3951,
        name = "Minimum Energy to Maintain Brightness",
        url = "https://leetcode.com/problems/minimum-energy-to-maintain-brightness/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumEnergyToMaintainBrightness {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        LinkedList<int[]> INT = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for (int[] i : intervals) {
            if (INT.isEmpty()) {
                INT.addLast(i);
            } else {
                if (INT.getLast()[1] >= i[0]) {
                    INT.getLast()[0] = Math.min(INT.getLast()[0], i[0]);
                    INT.getLast()[1] = Math.max(INT.getLast()[1], i[1]);
                } else {
                    INT.addLast(i);
                }
            }
        }

        long ans = 0;
        for (int[] interval : INT) {
            long positions;
            if (brightness % 3 == 0) {
                positions = brightness / 3;
            } else {
                positions = 1 + brightness / 3;
            }
            long time = 1L + interval[1] - interval[0];
            ans += time * positions;
        }
        return ans;
    }
}