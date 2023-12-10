package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(id = 811, name = "Subdomain Visit Count", url = "https://leetcode.com/problems/subdomain-visit-count/")
public class SubdomainVisitCount {
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> domainToVisits = new HashMap<>();
		for (String visit : cpdomains) {
			String[] parts = visit.split(" ");
			int count = Integer.parseInt(parts[0]);
			domainToVisits.put(parts[1], domainToVisits.getOrDefault(parts[1], 0) + count);
			int index = parts[1].indexOf('.');
			while (index != -1) {
				parts[1] = parts[1].substring(index + 1);
				domainToVisits.put(parts[1], domainToVisits.getOrDefault(parts[1], 0) + count);
				index = parts[1].indexOf('.');
			}
		}

		List<String> answer = new ArrayList<>(domainToVisits.size());
		for (Map.Entry<String, Integer> entry : domainToVisits.entrySet()) {
			answer.add(entry.getValue() + " " + entry.getKey());
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new SubdomainVisitCount().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
		System.out.println(new SubdomainVisitCount().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
	}
}
