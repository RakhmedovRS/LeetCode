package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-02
 */
@LeetCode(
        id = 3633,
        name = "Earliest Finish Time for Land and Water Rides I",
        url = "https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/",
        difficulty = Difficulty.EASY
)
public class EarliestFinishTimeForLandAndWaterRidesI {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int earliest = Integer.MAX_VALUE;
        for (int i = 0; i < landDuration.length; i++) {
            for (int j = 0; j < waterDuration.length; j++) {
                int landFirst = landStartTime[i] + landDuration[i];
                landFirst = Math.max(landFirst, waterStartTime[j]);
                landFirst += waterDuration[j];

                earliest = Math.min(earliest, landFirst);

                int waterFirst = waterStartTime[j] + waterDuration[j];
                waterFirst = Math.max(waterFirst, landStartTime[i]);
                waterFirst += landDuration[i];

                earliest = Math.min(earliest, waterFirst);
            }
        }

        return earliest;
    }
}