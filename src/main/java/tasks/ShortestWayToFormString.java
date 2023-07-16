package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 12/1/2020
 */
@LeetCode(
		id = 1055,
		name = "Shortest Way to Form String",
		url = "https://leetcode.com/problems/shortest-way-to-form-string/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ShortestWayToFormString
{
	public int shortestWay(String source, String target)
	{
		Map<Character, TreeSet<Integer>> positions = new HashMap<>();
		for (int i = 0; i < source.length(); i++)
		{
			char ch = source.charAt(i);
			positions.putIfAbsent(ch, new TreeSet<>());
			positions.get(ch).add(i);
		}

		int steps = 1;
		int currentPos = -1;
		Integer nextPos;
		for (char ch : target.toCharArray())
		{
			if (!positions.containsKey(ch))
			{
				return -1;
			}

			nextPos = positions.get(ch).ceiling(currentPos + 1);
			if (nextPos == null)
			{
				steps++;
				currentPos = positions.get(ch).first();
			}
			else
			{
				currentPos = nextPos;
			}
		}

		return steps;
	}

	public static void main(String[] args)
	{
		System.out.println(new ShortestWayToFormString().shortestWay("aaaaa", "aaaaaaaaaaaaa"));
		System.out.println(new ShortestWayToFormString().shortestWay("xyz", "xzyxz"));
		System.out.println(new ShortestWayToFormString().shortestWay("abc", "acdbc"));
		System.out.println(new ShortestWayToFormString().shortestWay("abc", "abcbc"));
	}
}
