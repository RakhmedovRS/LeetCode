package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/24/2021
 */
@LeetCode(
		id = 1737,
		name = "Change Minimum Characters to Satisfy One of Three Conditions",
		url = "https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/",
		difficulty = Difficulty.MEDIUM
)
public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
	public int minCharacters(String a, String b) {
		int[] tableA = createTable(a);
		int[] tableB = createTable(b);

		int makeEqualChars = getMinChanges(tableA, a.length()) + getMinChanges(tableB, b.length());
		int makeALess = costToMakeLess(tableA, a.length(), tableB);
		int makeBLess = costToMakeLess(tableB, b.length(), tableA);

		return Math.min(makeEqualChars, Math.min(makeALess, makeBLess));
	}

	private int[] createTable(String string) {
		int[] table = new int[26];
		for (char ch : string.toCharArray()) {
			table[ch - 'a']++;
		}
		return table;
	}

	private int getMinChanges(int[] table, int totalLen) {
		int min = Integer.MAX_VALUE;
		for (int count : table) {
			min = Math.min(min, totalLen - count);
		}

		return min;
	}

	private int costToMakeLess(int[] tableA, int aLen, int[] tableB) {
		int minCost = Integer.MAX_VALUE;
		int seenA = 0;
		int seenB = 0;
		for (int i = 0; i < tableA.length - 1; i++) {
			seenA += tableA[i];
			seenB += tableB[i];
			minCost = Math.min(minCost, aLen - seenA + seenB);
		}

		return minCost;
	}

	public static void main(String[] args) {
		ChangeMinimumCharactersToSatisfyOneOfThreeConditions clazz = new ChangeMinimumCharactersToSatisfyOneOfThreeConditions();
		System.out.println(clazz.minCharacters("a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
	}
}
