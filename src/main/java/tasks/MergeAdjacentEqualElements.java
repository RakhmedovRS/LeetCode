package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-07
 */
@LeetCode(
        id = 3834,
        name = "Merge Adjacent Equal Elements",
        url = "https://leetcode.com/problems/merge-adjacent-equal-elements/description/",
        difficulty = Difficulty.MEDIUM
)
public class MergeAdjacentEqualElements {
    public List<Long> mergeAdjacent(int[] nums) {
        LinkedList<Long> list = new LinkedList<>();
        for (long num : nums) {
            if (list.isEmpty() || !list.getLast().equals(num)) {
                list.addLast(num);
            } else {
                long val = num * 2;
                list.removeLast();
                while (!list.isEmpty() && list.getLast().equals(val)) {
                    val = list.removeLast() * 2;
                }
                list.addLast(val);
            }
        }
        return list;
    }
}