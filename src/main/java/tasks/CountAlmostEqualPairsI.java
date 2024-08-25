package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-24
 */
@LeetCode(
		id = 3265,
		name = "Count Almost Equal Pairs I",
		url = "https://leetcode.com/problems/count-almost-equal-pairs-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountAlmostEqualPairsI {
	public int countPairs(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			String iChars = nums[i] + "";
			for (int j = i + 1; j < nums.length; j++) {
				String jChars = nums[j] + "";
				if (generateCombinations(iChars.toCharArray()).contains(nums[j])
						|| generateCombinations(jChars.toCharArray()).contains(nums[i])) {
					ans++;
				}
			}
		}
		return ans;
	}

	private Set<Integer> generateCombinations(char[] source) {
		Set<Integer> combinations = new HashSet<>();
		combinations.add(Integer.parseInt(String.valueOf(source)));
		for (int i = 0; i < source.length; i++) {
			for (int j = i + 1; j < source.length; j++) {
				char iChar = source[i];
				char jChar = source[j];
				source[j] = iChar;
				source[i] = jChar;
				combinations.add(Integer.parseInt(String.valueOf(source)));
				source[i] = iChar;
				source[j] = jChar;
			}
		}
		return combinations;
	}
}