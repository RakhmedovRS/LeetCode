package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(
		id = 13,
		name = "Roman to Integer",
		url = "https://leetcode.com/problems/roman-to-integer/",
		difficulty = Difficulty.EASY
)
public class RomanToInteger
{
	public int romanToInt(String s)
	{
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int number = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; )
		{
			if (i + 1 < chars.length && map.get(chars[i]) < map.get(chars[i + 1]))
			{
				number += map.get(chars[i + 1]) - map.get(chars[i]);
				i += 2;
			}
			else if (i + 2 < chars.length && chars[i] == 'I' && chars[i + 1] == 'I' && chars[i + 2] == 'I')
			{
				number += 3;
				i += 3;
			}
			else
			{
				number += map.get(chars[i]);
				i++;
			}
		}

		return number;
	}
}
