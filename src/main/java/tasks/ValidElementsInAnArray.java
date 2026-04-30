package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-29
 */
@LeetCode(
        id = 3912,
        name = "Valid Elements in an Array",
        url = "https://leetcode.com/problems/valid-elements-in-an-array/description/",
        difficulty = Difficulty.EASY
)
public class ValidElementsInAnArray {
    public List<Integer> findValidElements(int[] nums) {
        int max = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                used[i] = true;
                ans.addLast(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }

        max = 0;
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!used[i] && nums[i] > max) {
                temp.addFirst(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }

        ans.addAll(temp);

        return ans;
    }
}