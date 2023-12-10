package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(
		id = 468,
		name = "Validate IP Address",
		url = "https://leetcode.com/problems/validate-ip-address/",
		difficulty = Difficulty.MEDIUM
)
public class ValidateIPAddress {
	public String validIPAddress(String IP) {
		if (isIPV4(IP)) {
			return "IPv4";
		}
		else if (isIPV6(IP)) {
			return "IPv6";
		}
		else {
			return "Neither";
		}
	}

	private boolean isIPV4(String ip) {
		if (countOfChar(ip, '.') != 3) {
			return false;
		}

		String[] parts = ip.split("\\.");
		if (parts.length != 4) {
			return false;
		}

		Set<String> valid = new HashSet<>();
		for (int i = 0; i < 256; i++) {
			valid.add("" + i);
		}

		for (String part : parts) {
			if (!valid.contains(part)) {
				return false;
			}
		}

		return true;
	}

	private boolean isIPV6(String ip) {
		if (countOfChar(ip, ':') != 7) {
			return false;
		}

		String[] parts = ip.split(":");
		if (parts.length != 8) {
			return false;
		}

		for (String part : parts) {
			if (part.isEmpty() || part.length() > 4) {
				return false;
			}

			for (int i = 0; i < part.length(); i++) {
				char ch = Character.toLowerCase(part.charAt(i));
				if (ch < '0' || ch > 'f') {
					return false;
				}
			}
		}

		return true;
	}

	private int countOfChar(String ip, char ch) {
		int count = 0;
		for (int i = 0; i < ip.length(); i++) {
			if (ip.charAt(i) == ch) {
				count++;
			}
		}

		return count;
	}
}
