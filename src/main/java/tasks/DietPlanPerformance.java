package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/24/2020
 */
@LeetCode(
		id = 1176,
		name = "Diet Plan Performance",
		url = "https://leetcode.com/problems/diet-plan-performance/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class DietPlanPerformance {
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
		int balance = 0;
		int left = 0;
		int right = 0;
		int sum = 0;
		while (right < calories.length) {
			sum += calories[right];
			if (1 + right - left >= k) {
				if (1 + right - left > k) {
					sum -= calories[left++];
				}

				if (sum < lower) {
					balance--;
				}
				else if (sum > upper) {
					balance++;
				}
			}

			right++;
		}

		return balance;
	}

	public static void main(String[] args) {
		DietPlanPerformance clazz = new DietPlanPerformance();
		System.out.println(clazz.dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3));
		System.out.println(clazz.dietPlanPerformance(new int[]{3, 2}, 2, 0, 1));
	}
}
