import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 02-Apr-20
 */
@LeetCode(id = 229, name = "Majority Element II", url = "https://leetcode.com/problems/majority-element-ii/")
public class MajorityElementII
{
	public List<Integer> majorityElement1(int[] nums)
	{
		Map<Integer, Integer> memo = new HashMap<>();
		for (Integer num : nums)
		{
			memo.put(num, memo.getOrDefault(num, 0) + 1);
		}

		return memo.entrySet().stream().filter(entry -> entry.getValue() > nums.length / 3).map(Map.Entry::getKey).collect(Collectors.toList());
	}

	public List<Integer> majorityElement(int[] nums)
	{
		List<Integer> rst = new ArrayList<>();
		if (nums == null || nums.length == 0)
		{
			return rst;
		}

		int count1 = 0;
		int count2 = 0;
		int candidate1 = 0;
		int candidate2 = 1;
		for (int num : nums)
		{
			if (num == candidate1)
			{
				count1++;
			}
			else if (num == candidate2)
			{
				count2++;
			}
			else if (count1 == 0)
			{
				candidate1 = num;
				count1 = 1;
			}
			else if (count2 == 0)
			{
				candidate2 = num;
				count2 = 1;
			}
			else
			{
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for (int num : nums)
		{
			if (num == candidate1)
			{
				count1 += 2;
			}
			else
			{
				count1--;
			}

			if (num == candidate2)
			{
				count2 += 2;
			}
			else
			{
				count2--;
			}
		}

		if (count1 > 0)
		{
			rst.add(candidate1);
		}

		if (count2 > 0)
		{
			rst.add(candidate2);
		}

		return rst;
	}

	public static void main(String[] args)
	{
		System.out.println(new MajorityElementII().majorityElement(new int[]{}));
		System.out.println(new MajorityElementII().majorityElement(new int[]{3, 2, 3}));
		System.out.println(new MajorityElementII().majorityElement(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
	}
}
