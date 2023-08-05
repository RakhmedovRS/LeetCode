package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/5/2023
 */
@LeetCode(
		id = 2806,
		name = "Account Balance After Rounded Purchase",
		url = "https://leetcode.com/problems/account-balance-after-rounded-purchase/description/",
		difficulty = Difficulty.EASY
)
public class AccountBalanceAfterRoundedPurchase
{
	public int accountBalanceAfterPurchase(int purchaseAmount)
	{
		int rem = purchaseAmount % 10;
		if (rem == 0)
		{
			return 100 - purchaseAmount;
		}

		if (rem >= 5)
		{
			return 100 - (purchaseAmount + (10 - rem));
		}

		return 100 - (purchaseAmount - rem);
	}
}
