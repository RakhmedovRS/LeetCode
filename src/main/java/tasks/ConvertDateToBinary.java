package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-29
 */
@LeetCode(
        id = 3280,
        name = "Convert Date to Binary",
        url = "https://leetcode.com/problems/convert-date-to-binary/description/",
        difficulty = Difficulty.EASY
)
public class ConvertDateToBinary {
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        return Integer.toBinaryString(Integer.parseInt(parts[0], 10))
                + "-"
                + Integer.toBinaryString(Integer.parseInt(parts[1], 10))
                + "-" + Integer.toBinaryString(Integer.parseInt(parts[2], 10));
    }
}