package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-02
 */
@LeetCode(
        id = 3635,
        name = "Earliest Finish Time for Land and Water Rides II",
        url = "https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class EarliestFinishTimeForLandAndWaterRidesII {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        List<int[]> land = new ArrayList<>();
        for (int i = 0; i < landStartTime.length; i++) {
            land.add(new int[]{landStartTime[i], landDuration[i]});
        }

        List<int[]> water = new ArrayList<>();
        for (int i = 0; i < waterStartTime.length; i++) {
            water.add(new int[]{waterStartTime[i], waterDuration[i]});
        }

        land.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        water.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int landEarliest = Integer.MAX_VALUE;
        for (int[] pair : land) {
            int res = pair[0] + pair[1];
            if (res < landEarliest) {
                landEarliest = res;
            }
        }

        int waterEarliest = Integer.MAX_VALUE;
        for (int[] pair : water) {
            int res = pair[0] + pair[1];
            if (res < waterEarliest) {
                waterEarliest = res;
            }
        }

        int earliest = Integer.MAX_VALUE;
        for (int[] pair : land) {
            int res;
            if (pair[0] <= waterEarliest) {
                res = waterEarliest + pair[1];
            } else {
                res = pair[0] + pair[1];
            }
            earliest = Math.min(earliest, res);
        }

        for (int[] pair : water) {
            int res;
            if (pair[0] <= landEarliest) {
                res = landEarliest + pair[1];
            } else {
                res = pair[0] + pair[1];
            }
            earliest = Math.min(earliest, res);
        }

        return earliest;
    }
}