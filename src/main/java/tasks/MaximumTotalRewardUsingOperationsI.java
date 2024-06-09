package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-09
 */
@LeetCode(
		id = 3180,
		name = "Maximum Total Reward Using Operations I",
		url = "https://leetcode.com/problems/maximum-total-reward-using-operations-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumTotalRewardUsingOperationsI {
	public int maxTotalReward(int[] rewardValues) {
		Arrays.sort(rewardValues);
		TreeSet<Integer> pq = new TreeSet<>();
		pq.add(0);
		int max = 0;
		for (int reward : rewardValues) {
			List<Integer> list = new ArrayList<>();
			for (int r : pq) {
				if (r >= reward) {
					break;
				}
				list.add(r + reward);
				max = Math.max(max, r + reward);
			}
			pq.addAll(list);
		}
		return max;
	}
}