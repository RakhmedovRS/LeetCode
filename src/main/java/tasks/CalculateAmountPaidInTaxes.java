package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/16/2022
 */
@LeetCode(
		id = 2303,
		name = "Calculate Amount Paid in Taxes",
		url = "https://leetcode.com/problems/calculate-amount-paid-in-taxes/",
		difficulty = Difficulty.EASY
)
public class CalculateAmountPaidInTaxes
{
	public double calculateTax(int[][] brackets, int income)
	{
		double tax = 0;
		double rest = income;
		int prev = 0;
		for (int[] bracket : brackets)
		{
			double t = (Math.min(rest, bracket[0] - prev) * bracket[1]) / 100;
			rest -= Math.min(rest, bracket[0] - prev);
			tax += t;
			prev = bracket[0];
		}

		return tax;
	}
}
