package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-07-18
 */
@LeetCode(
        id = 3986,
        name = "Number of Elapsed Seconds Between Two Times",
        url = "https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/description/",
        difficulty = Difficulty.EASY
)
public class NumberOfElapsedSecondsBetweenTwoTimes {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return calc(endTime.split(":")) - calc(startTime.split(":"));
    }

    private int calc(String[] parts) {
        int time = 0;
        time += Integer.parseInt(parts[2]);
        time += Integer.parseInt(parts[1]) * 60;
        time += Integer.parseInt(parts[0]) * 60 * 60;

        return time;
    }
}