package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-20
 */
@LeetCode(
		id = 3224,
		name = "Minimum Array Changes to Make Differences Equal",
		url = "https://leetcode.com/problems/minimum-array-changes-to-make-differences-equal/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumArrayChangesToMakeDifferencesEqual {
	public int minChanges(int[] nums, int k) {
		Map<Integer, Integer> memo = new HashMap<>();
		int max = 0;
		int min = 0;
		for (int i = 0; i < nums.length / 2; i++) {
			int res = Math.abs(nums[i] - nums[nums.length - i - 1]);
			memo.put(res, memo.getOrDefault(res, 0) + 1);
			max = Math.max(max, memo.get(res));
			if (nums[i] > 0) {
				min = Math.min(min, nums[i]);
			}

			if (nums[nums.length - i - 1] > 0) {
				min = Math.min(min, nums[nums.length - i - 1]);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> memo.get(b) - memo.get(a));
		pq.addAll(memo.keySet());
		int ans = Integer.MAX_VALUE;
/*		for (int i = 0; i <= k; i++) {
			ans = Math.min(ans, minChanges(nums, k, i));
		}*/
		Integer smallerMax = null;
		while (!pq.isEmpty() && (memo.get(pq.peek()).equals(max) || memo.get(pq.peek()).equals(smallerMax))) {
			int res = pq.remove();
			if (!pq.isEmpty() && !memo.get(pq.peek()).equals(max) && smallerMax == null) {
				smallerMax = memo.get(pq.peek());
			}
			ans = Math.min(ans, minChanges(nums, k, res));
		}

		ans = Math.min(ans, minChanges(nums, k, 0));
		ans = Math.min(ans, minChanges(nums, k, min));
		return ans;
	}

	private int minChanges(int[] nums, int k, int target) {
		int changes = 0;
		for (int i = 0; i < nums.length / 2; i++) {
			//System.out.println(nums[i] + " " + nums[nums.length - i - 1]);
			if (Math.abs(nums[i] - nums[nums.length - i - 1]) != target) {
				if (nums[i] >= target
						|| nums[nums.length - i - 1] >= target
						|| Math.abs((k - nums[i])) >= target
						|| Math.abs(k - nums[nums.length - i - 1]) >= target
						|| (nums[i] == 0 && nums[nums.length - i - 1] == 0)) {
					changes++;
				} else {
					changes += 2;
				}
			}
		}
		//System.out.println("------------");
		return changes;
	}
}