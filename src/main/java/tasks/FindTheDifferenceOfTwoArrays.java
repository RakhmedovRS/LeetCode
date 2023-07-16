package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 3/27/2022
 */
@LeetCode(
		id = 2215,
		name = "Find the Difference of Two Arrays",
		url = "https://leetcode.com/problems/find-the-difference-of-two-arrays/",
		difficulty = Difficulty.EASY
)
public class FindTheDifferenceOfTwoArrays
{
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2)
	{
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int num : nums1)
		{
			set1.add(num);
		}

		for (int num : nums2)
		{
			set2.add(num);
		}

		List<List<Integer>> answer = new ArrayList<>();
		Set<Integer> list = new HashSet<>();
		for (int num : nums1)
		{
			if (!set2.contains(num))
			{
				list.add(num);
			}
		}

		answer.add(new ArrayList<>(list));

		list = new HashSet<>();
		for (int num : nums2)
		{
			if (!set1.contains(num))
			{
				list.add(num);
			}
		}

		answer.add(new ArrayList<>(list));

		return answer;
	}
}
