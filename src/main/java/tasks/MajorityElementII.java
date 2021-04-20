package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-Apr-20
 */
@LeetCode(id = 229, name = "Majority Element II", url = "https://leetcode.com/problems/majority-element-ii/")
public class MajorityElementII
{
	public List<Integer> majorityElement(int[] nums)
	{
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if (entry.getValue() > nums.length / 3)
			{
				answer.add(entry.getKey());
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new MajorityElementII().majorityElement(new int[]{}));
		System.out.println(new MajorityElementII().majorityElement(new int[]{3, 2, 3}));
		System.out.println(new MajorityElementII().majorityElement(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
	}
}
