package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
@LeetCode(
		id = 1002,
		name = "Find Common Characters",
		url = "https://leetcode.com/problems/find-common-characters/",
		difficulty = Difficulty.EASY
)
public class FindCommonCharacters
{
	public List<String> commonChars(String[] A)
	{
		List<String> answer = new ArrayList<>();
		if (A == null || A.length <= 0)
		{
			return answer;
		}

		Map<Character, int[]> memo = new HashMap<>();
		for (int i = 0; i < A.length; i++)
		{
			for (Character ch : A[i].toCharArray())
			{
				int[] arr = memo.get(ch);
				if (arr == null)
				{
					arr = new int[A.length];
				}

				arr[i]++;

				memo.put(ch, arr);
			}
		}

		outer:
		for (Map.Entry<Character, int[]> entry : memo.entrySet())
		{
			int[] arr = entry.getValue();
			int min = Integer.MAX_VALUE;
			for (Integer value : arr)
			{
				if (value == 0)
				{
					continue outer;
				}
				if (min > value)
				{
					min = value;
				}
			}

			while (min-- > 0)
			{
				answer.add(String.valueOf(entry.getKey()));
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindCommonCharacters().commonChars(new String[]{"bella", "label", "roller"}));
		System.out.println(new FindCommonCharacters().commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
	}
}
