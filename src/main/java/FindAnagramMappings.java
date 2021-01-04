import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/4/2021
 */
@LeetCode(
	id = 760,
	name = "Find Anagram Mappings",
	url = "https://leetcode.com/problems/find-anagram-mappings/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class FindAnagramMappings
{
	public int[] anagramMappings(int[] A, int[] B)
	{
		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		for (int i = 0; i < B.length; i++)
		{
			map.putIfAbsent(B[i], new LinkedList<>());
			map.get(B[i]).add(i);
		}

		int[] answer = new int[A.length];
		for (int i = 0; i < A.length; i++)
		{
			answer[i] = map.get(A[i]).removeFirst();
		}

		return answer;
	}
}
