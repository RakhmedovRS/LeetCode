import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(id = 260, name = "Single Number III", url = "https://leetcode.com/problems/single-number-iii/")
public class SingleNumberIII
{
	public int[] singleNumber(int[] nums)
	{
		Map<Integer, Integer> memo = new HashMap<>();
		for (int num : nums)
		{
			memo.put(num, memo.getOrDefault(num, 0) + 1);
		}

		int[] answer = new int[2];
		int pos = 0;
		for (Map.Entry<Integer, Integer> entry : memo.entrySet())
		{
			if (entry.getValue() == 1)
			{
				answer[pos++] = entry.getKey();
				if (pos > 1)
				{
					break;
				}
			}
		}

		return answer;
	}
}
