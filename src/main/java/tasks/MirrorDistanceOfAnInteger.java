package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-20
 */
@LeetCode(
        id = 3783,
        name = "Mirror Distance of an Integer",
        url = "https://leetcode.com/problems/mirror-distance-of-an-integer/description/",
        difficulty = Difficulty.EASY
)
public class MirrorDistanceOfAnInteger {
    public int mirrorDistance(int n) {
        long num = Long.parseLong(new StringBuilder("" + n).reverse().toString());
        return (int) (Math.abs(num - n));
    }
}