package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/16/2022
 */
@LeetCode(
	id = 2241,
	name = "Design an ATM Machine",
	url = "https://leetcode.com/problems/design-an-atm-machine/",
	difficulty = Difficulty.MEDIUM
)
public class DesignAnATMMachine
{
	class ATM
	{
		long[] banknote;
		int[] value;

		public ATM()
		{
			banknote = new long[5];
			value = new int[]{20,50,100,200,500};
		}

		public void deposit(int[] banknotesCount)
		{
			for (int i = 0; i < banknote.length; i++)
			{
				banknote[i] += banknotesCount[i];
			}
		}

		public int[] withdraw(int amount)
		{
			if (amount < 20)
			{
				return new int[]{-1};
			}

			int[] used = new int[banknote.length];
			int pos = banknote.length - 1;
			while (amount > 0 && pos >= 0)
			{
				if (banknote[pos] != 0 && amount >= value[pos])
				{
					used[pos] = (int)Math.min(amount / value[pos], banknote[pos]);
					amount -= value[pos] * used[pos];
				}

				pos--;
			}

			if (amount == 0)
			{
				for (int i = 0; i < banknote.length; i++)
				{
					banknote[i] -= used[i];
				}

				return used;
			}

			return new int[]{-1};
		}
	}
}
