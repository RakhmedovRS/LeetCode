package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(id = 676, name = "Implement Magic Dictionary", url = "https://leetcode.com/problems/implement-magic-dictionary/")
public class ImplementMagicDictionary {
	class MagicDictionary {
		Map<String, Set<String>> memo;

		public MagicDictionary() {
			memo = new HashMap<>();
		}

		public void buildDict(String[] dict) {
			for (String word : dict) {
				char[] chars = word.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char temp = chars[i];
					chars[i] = '*';
					String newVal = String.valueOf(chars);
					Set<String> values = memo.getOrDefault(newVal, new HashSet<>());
					values.add(word);
					memo.put(newVal, values);
					chars[i] = temp;
				}
			}
		}

		public boolean search(String word) {
			char[] chars = word.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char temp = chars[i];
				chars[i] = '*';
				Set<String> values = memo.getOrDefault(String.valueOf(chars), Collections.emptySet());
				if (!values.isEmpty()) {
					if (values.size() > 1 || !values.contains(word)) {
						return true;
					}
				}
				chars[i] = temp;
			}

			return false;
		}
	}
}
