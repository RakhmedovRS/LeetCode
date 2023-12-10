package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/9/2021
 */
@LeetCode(
		id = 1716,
		name = "Calculate Money in Leetcode Bank",
		url = "https://leetcode.com/problems/calculate-money-in-leetcode-bank/",
		difficulty = Difficulty.EASY
)
public class CalculateMoneyInLeetcodeBank {
	public int totalMoney(int n) {
		int count = 0;
		int amount = 0;
		int currAmount = 0;
		for (int i = 0; i < n; i++) {
			if (i % 7 == 0) {
				amount++;
				currAmount = amount;
			}

			count += currAmount;
			currAmount++;
		}
		return count;
	}

	public static void main(String[] args) {
		CalculateMoneyInLeetcodeBank clazz = new CalculateMoneyInLeetcodeBank();
		System.out.println(clazz.totalMoney(4));
		System.out.println(clazz.totalMoney(10));
		System.out.println(clazz.totalMoney(20));
	}
}
