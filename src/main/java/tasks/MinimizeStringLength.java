package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 6/10/2023
 */
@LeetCode(
		id = 2716,
		name = "Minimize String Length",
		url = "https://leetcode.com/problems/minimize-string-length/description/",
		difficulty = Difficulty.EASY
)
public class MinimizeStringLength
{
	public int minimizedStringLength(String s)
	{
		Set<Character> characters = new HashSet<>();
		for (char ch : s.toCharArray())
		{
			characters.add(ch);
		}

		return characters.size();
	}
}
