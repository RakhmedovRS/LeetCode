package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/17/2021
 */
@LeetCode(
		id = 2043,
		name = "Simple Bank System",
		url = "https://leetcode.com/problems/simple-bank-system/",
		difficulty = Difficulty.MEDIUM
)
public class SimpleBankSystem {
	class Bank {

		int n;
		long[] balance;

		public Bank(long[] balance) {
			this.balance = balance;
			n = balance.length;
		}

		public boolean transfer(int account1, int account2, long money) {
			if (account1 >= 1 && account1 <= n && account2 >= 1 && account2 <= n) {
				if (balance[account1 - 1] < money) {
					return false;
				}

				balance[account1 - 1] -= money;
				balance[account2 - 1] += money;

				return true;
			}

			return false;
		}

		public boolean deposit(int account, long money) {
			if (account >= 1 && account <= n) {
				balance[account - 1] += money;
				return true;
			}

			return false;
		}

		public boolean withdraw(int account, long money) {
			if (account >= 1 && account <= n && balance[account - 1] >= money) {
				balance[account - 1] -= money;
				return true;
			}

			return false;
		}
	}
}
