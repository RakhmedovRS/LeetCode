package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 2/28/2021
 */
@LeetCode(
		id = 1774,
		name = "Closest Dessert Cost",
		url = "https://leetcode.com/problems/closest-dessert-cost/",
		difficulty = Difficulty.MEDIUM
)
public class ClosestDessertCost {
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		int[] diff = new int[]{Integer.MAX_VALUE};
		int[] answer = new int[]{Integer.MAX_VALUE};
		Arrays.sort(baseCosts);
		Arrays.sort(toppingCosts);
		for (int baseCost : baseCosts) {
			dfs(0, toppingCosts, diff, target, answer, baseCost);
		}
		return answer[0];
	}

	private void dfs(int pos, int[] toppingCosts, int[] diff, int target, int[] answer, int sum) {
		if (diff[0] > Math.abs(sum - target)) {
			diff[0] = Math.abs(sum - target);
			answer[0] = sum;
		}
		else if (diff[0] == Math.abs(sum - target)) {
			answer[0] = Math.min(answer[0], sum);
		}

		if (sum >= target) {
			return;
		}

		if (pos == toppingCosts.length) {
			return;
		}

		for (int i = pos; i < toppingCosts.length; i++) {
			dfs(i + 1, toppingCosts, diff, target, answer, sum);
			dfs(i + 1, toppingCosts, diff, target, answer, sum + toppingCosts[i]);
			dfs(i + 1, toppingCosts, diff, target, answer, sum + toppingCosts[i] * 2);
		}
	}

	public static void main(String[] args) {
		ClosestDessertCost clazz = new ClosestDessertCost();
		System.out.println(clazz.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
		System.out.println(clazz.closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
	}
}
