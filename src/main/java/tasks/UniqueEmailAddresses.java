package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(id = 929, name = "Unique Email Addresses", url = "https://leetcode.com/problems/unique-email-addresses/")
public class UniqueEmailAddresses
{
	public int numUniqueEmails(String[] emails)
	{
		Set<String> uniqueEmails = new HashSet<>();
		if (emails == null || emails.length == 0)
		{
			return uniqueEmails.size();
		}

		for (String email : emails)
		{
			StringBuilder emailBuilder = new StringBuilder();
			String[] parts = email.split("@");
			for (char ch : parts[0].toCharArray())
			{
				if (ch == '.')
				{
					continue;
				}
				if (ch == '+')
				{
					break;
				}
				emailBuilder.append(ch);
			}
			if (emailBuilder.length() != 0)
			{
				emailBuilder.append('@');
				emailBuilder.append(parts[1]);
				uniqueEmails.add(emailBuilder.toString());
			}
		}

		return uniqueEmails.size();
	}
}
