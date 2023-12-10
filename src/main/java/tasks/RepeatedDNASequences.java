package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 187, name = "Repeated DNA Sequences", url = "https://leetcode.com/problems/repeated-dna-sequences/")
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		String sub;
		for (int i = 10; i <= s.length(); i++) {
			sub = s.substring(i - 10, i);
			if (map.getOrDefault(sub, 0) == 1) {
				answer.add(sub);
			}

			map.put(sub, map.getOrDefault(sub, 0) + 1);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
