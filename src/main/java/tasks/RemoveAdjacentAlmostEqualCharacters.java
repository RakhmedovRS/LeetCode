package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/9/2023
 */
@LeetCode(
		id = 2957,
		name = "Remove Adjacent Almost-Equal Characters",
		url = "https://leetcode.com/problems/remove-adjacent-almost-equal-characters/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveAdjacentAlmostEqualCharacters
{
	public int removeAlmostEqualCharacters(String word) {
		char[] charsA = word.toCharArray();
		char[] charsB = word.toCharArray();

		int opsA = 0;
		for (int i = 1; i < charsA.length; i++) {
			char prev = charsA[i - 1];
			char curr = charsA[i];
			char next = i + 1 < charsA.length ? charsA[i + 1] : 'D';
			if (curr == prev || Math.abs(prev - curr) == 1) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (ch != prev && Math.abs(prev - ch) != 1 && ch != next && Math.abs(next - ch) != 1) {
						charsA[i] = ch;
						opsA++;
						break;
					}
				}
			}
		}

		int opsB = 0;
		for (int i = 0; i < charsB.length - 1; i++) {
			char prev = i - 1 < 0 ? 'D' : charsB[i - 1];
			char curr = charsB[i];
			char next = charsB[i + 1];
			if (curr == next || Math.abs(next - curr) == 1) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (ch != next && Math.abs(next - ch) != 1 && ch != prev && Math.abs(prev - ch) != 1) {
						charsB[i] = ch;
						opsB++;
						break;
					}
				}
			}
		}

		return Math.min(opsA, opsB);
	}
}
