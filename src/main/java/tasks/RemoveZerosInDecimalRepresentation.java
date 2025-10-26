package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-25
 */
@LeetCode(
        id = 3726,
        name = "Remove Zeros in Decimal Representation",
        url = "https://leetcode.com/problems/remove-zeros-in-decimal-representation/description/",
        difficulty = Difficulty.EASY
)
public class RemoveZerosInDecimalRepresentation {
    public long removeZeros(long n) {
        return Long.parseLong(("" + n).replaceAll("0", ""));
    }
}