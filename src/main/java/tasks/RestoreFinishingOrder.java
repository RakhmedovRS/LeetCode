package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-02
 */
@LeetCode(
        id = 3668,
        name = "Restore Finishing Order",
        url = "https://leetcode.com/problems/restore-finishing-order/description/",
        difficulty = Difficulty.EASY
)
public class RestoreFinishingOrder {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> fSet = new HashSet<>(friends.length);
        for (int f : friends) {
            fSet.add(f);
        }

        int pos = 0;
        int[] ans = new int[friends.length];
        for (int o : order) {
            if (fSet.contains(o)) {
                ans[pos++] = o;
            }
        }
        return ans;
    }
}