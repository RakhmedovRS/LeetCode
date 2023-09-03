package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/2/2023
 */
@LeetCode(
		id = 2840,
		name = "Check if Strings Can be Made Equal With Operations II",
		url = "https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfStringsCanBeMadeEqualWithOperationsII
{
	public boolean checkStrings(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		Map<Integer, LinkedList<Character>> map1 = new HashMap<>();
		for (int i = 0; i < a1.length; i++)
		{
			map1.putIfAbsent(i % 2, new LinkedList<>());
			map1.get(i % 2).add(a1[i]);
		}

		Map<Integer, LinkedList<Character>> map2 = new HashMap<>();
		for (int i = 0; i < a2.length; i++)
		{
			map2.putIfAbsent(i % 2, new LinkedList<>());
			map2.get(i % 2).add(a2[i]);
		}

		map1.get(0).sort(null);
		map2.get(0).sort(null);

		if (a1.length > 1)
		{
			map1.get(1).sort(null);
			map2.get(1).sort(null);
		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < a1.length; i++)
		{
			sb1.append(map1.get(i % 2).removeFirst());
			sb2.append(map2.get(i % 2).removeFirst());
		}

		return sb1.toString().equals(sb2.toString());
	}
}
