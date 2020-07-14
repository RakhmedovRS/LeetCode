import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(id = 1169, name = "Invalid Transactions", url = "https://leetcode.com/problems/invalid-transactions/")
public class InvalidTransactions
{
	class Transaction
	{
		String name;
		int time;
		int amount;
		String city;
		String origin;

		public Transaction(String name, int time, int amount, String city, String origin)
		{
			this.name = name;
			this.time = time;
			this.amount = amount;
			this.city = city;
			this.origin = origin;
		}
	}

	public List<String> invalidTransactions(String[] origins)
	{
		Set<String> answer = new HashSet<>();
		Map<String, List<Transaction>> transactionMap = new HashMap<>();
		for (String origin : origins)
		{
			Transaction transaction = parseTransaction(origin);

			if (transaction.amount > 1000)
			{
				answer.add(origin);
			}

			List<Transaction> transactions = transactionMap.getOrDefault(transaction.name, new ArrayList<>());
			if (!transactions.isEmpty())
			{
				for (Transaction oldTransaction : transactions)
				{
					if (!oldTransaction.city.equals(transaction.city) && Math.abs(transaction.time - oldTransaction.time) <= 60)
					{
						answer.add(oldTransaction.origin);
						answer.add(transaction.origin);
					}
				}
			}

			transactions.add(transaction);
			transactionMap.put(transaction.name, transactions);
		}

		return new ArrayList<>(answer);
	}

	private Transaction parseTransaction(String string)
	{
		String[] info = string.split(",");
		String name = info[0];
		int time = Integer.parseInt(info[1]);
		int amount = Integer.parseInt(info[2]);
		String city = info[3];
		return new Transaction(name, time, amount, city, string);
	}
}
