package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-06
 */
@LeetCode(
		id = 3211,
		name = "Generate Binary Strings Without Adjacent Zeros",
		url = "https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/",
		difficulty = Difficulty.MEDIUM
)
public class GenerateBinaryStringsWithoutAdjacentZeros {
	public List<String> validStrings(int n) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> numbers = Arrays.asList(0, 1);
		for (int len = 2; len <= n; len++) {
			List<Integer> nextNumbers = new ArrayList<>();
			for (int num : numbers) {
				if ((num & 1) == 1) {
					nextNumbers.add(((num << 1)));
				}
				nextNumbers.add(((num << 1) ^ 1));
			}
			numbers = nextNumbers;
		}

		List<String> answer = new ArrayList<>();
		for (int num : numbers) {
			String bits = Integer.toBinaryString(num);
			if (bits.length() != n) {
				bits = "0" + bits;
			}
			answer.add(bits);
		}
		return answer;
	}
}