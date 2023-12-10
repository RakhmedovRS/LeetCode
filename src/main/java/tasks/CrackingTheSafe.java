package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/10/2020
 */
@LeetCode(
		id = 753,
		name = "Cracking the Safe",
		url = "https://leetcode.com/problems/cracking-the-safe/",
		difficulty = Difficulty.HARD)
public class CrackingTheSafe {
	public String crackSafe(int maxPositions, int maxNumber) {
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < maxPositions; i++) {
			password.append(0);
		}

		Set<String> seen = new HashSet<>();
		seen.add(password.toString());

		int combinationNumbers = (int) Math.pow(maxNumber, maxPositions);

		canCrackTheSafe(password, seen, combinationNumbers, maxPositions, maxNumber);

		return password.toString();
	}

	private boolean canCrackTheSafe(StringBuilder password, Set<String> seen, int combinationNumbers, int maxPositions, int maxNumber) {
		System.out.println(password);
		if (seen.size() == combinationNumbers) {
			return true;
		}

		String lastNumbers = password.substring(1 + password.length() - maxPositions);
		String newCombination;
		for (char ch = '0'; ch < '0' + maxNumber; ch++) {
			newCombination = lastNumbers + ch;
			if (seen.add(newCombination)) {
				password.append(ch);
				if (canCrackTheSafe(password, seen, combinationNumbers, maxPositions, maxNumber)) {
					return true;
				}
				seen.remove(newCombination);
				password.deleteCharAt(password.length() - 1);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new CrackingTheSafe().crackSafe(2, 3));
		System.out.println(new CrackingTheSafe().crackSafe(1, 2));
		System.out.println(new CrackingTheSafe().crackSafe(2, 2));
		System.out.println(new CrackingTheSafe().crackSafe(3, 3));
	}
}
