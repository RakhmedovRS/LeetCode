package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-11
 */
@LeetCode(
        id = 3894,
        name = "Traffic Signal Color",
        url = "https://leetcode.com/problems/traffic-signal-color/description/",
        difficulty = Difficulty.EASY
)
public class TrafficSignalColor {
    public String trafficSignal(int timer) {
        if (timer == 0) {
            return "Green";
        } else if (timer == 30) {
            return "Orange";
        } else if (timer > 30 && timer <= 90) {
            return "Red";
        }

        return "Invalid";
    }
}