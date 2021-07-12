package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(
	id = 205,
	name = "Isomorphic Strings",
	url = "https://leetcode.com/problems/isomorphic-strings/",
	difficulty = Difficulty.EASY)
public class IsomorphicStrings
{
	public boolean isIsomorphic(String s, String t)
	{
		Map<Character, Character> mapA = new HashMap<>();
		Map<Character, Character> mapB = new HashMap<>();
		char[] charsA = s.toCharArray();
		char[] charsB = t.toCharArray();
		for (int i = 0; i < charsA.length; i++)
		{
			if (mapA.getOrDefault(charsA[i], charsB[i]) != charsB[i] || mapB.getOrDefault(charsB[i], charsA[i]) != charsA[i])
			{
				return false;
			}
			mapA.put(charsA[i], charsB[i]);
			mapB.put(charsB[i], charsA[i]);
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
		System.out.println(new IsomorphicStrings().isIsomorphic("abba", "abab"));
		System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
		System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
	}
}
