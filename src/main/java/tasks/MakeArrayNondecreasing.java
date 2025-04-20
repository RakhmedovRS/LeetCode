package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-20
 */
@LeetCode(
        id = 3523,
        name = "Make Array Non-decreasing",
        url = "https://leetcode.com/problems/make-array-non-decreasing/description/",
        difficulty = Difficulty.MEDIUM
)
public class MakeArrayNondecreasing {
    public int maximumPossibleSize(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.getLast() <= num) {
                list.add(num);
            }
        }
        return list.size();
    }
}