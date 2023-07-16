package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/7/2021
 */
@LeetCode(
		id = 721,
		name = "Accounts Merge",
		url = "https://leetcode.com/problems/accounts-merge/",
		difficulty = Difficulty.MEDIUM
)
public class AccountsMerge
{
	class Account
	{
		String name;
		Set<String> emails;

		public Account(String name, Set<String> emails)
		{
			this.name = name;
			this.emails = emails;
		}
	}

	public List<List<String>> accountsMerge(List<List<String>> accountsList)
	{
		List<Account> accounts = new ArrayList<>();
		Set<Account> accountsSet = new HashSet<>();
		for (List<String> acc : accountsList)
		{
			String name = acc.get(0);
			Set<String> emails = new HashSet<>(acc);
			emails.remove(name);
			accounts.add(new Account(name, emails));
		}

		Map<String, Account> union = new HashMap<>();
		Set<Account> heirs;
		for (Account account : accounts)
		{
			heirs = new HashSet<>();
			for (String email : account.emails)
			{
				if (union.containsKey(email))
				{
					heirs.add(union.get(email));
				}
			}

			if (!heirs.isEmpty())
			{
				for (Account heir : heirs)
				{
					accountsSet.remove(heir);
					account.emails.addAll(heir.emails);
				}
			}

			for (String email : account.emails)
			{
				union.put(email, account);
			}

			accountsSet.add(account);
		}

		return buildAnswer(accountsSet);
	}

	private List<List<String>> buildAnswer(Set<Account> accountSet)
	{
		List<List<String>> answer = new ArrayList<>();
		for (Account account : accountSet)
		{
			List<String> accountString = new ArrayList<>();
			accountString.add(account.name);

			List<String> emails = new ArrayList<>(account.emails);
			emails.sort(null);

			accountString.addAll(emails);
			answer.add(accountString);
		}

		return answer;
	}
}
