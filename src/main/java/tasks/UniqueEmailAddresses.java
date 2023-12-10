package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(
		id = 929,
		name = "Unique Email Addresses",
		url = "https://leetcode.com/problems/unique-email-addresses/",
		difficulty = Difficulty.EASY
)
public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {
		Map<String, Set<String>> emailsMap = new HashMap<>();
		for (String email : emails) {
			String[] emailParts = email.split("@");
			String name = emailParts[0].replace(".", "");
			String domain = emailParts[1];

			emailsMap.putIfAbsent(domain, new HashSet<>());

			name = name.contains("+") ? name.substring(0, name.indexOf("+")) : name;
			emailsMap.get(domain).add(name);
		}


		int count = 0;
		for (Set<String> names : emailsMap.values()) {
			count += names.size();
		}

		return count;
	}
}
