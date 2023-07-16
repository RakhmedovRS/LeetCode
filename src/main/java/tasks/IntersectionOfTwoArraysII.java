package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 28-Mar-20
 */
@LeetCode(
		id = 350,
		name = "Intersection of Two Arrays II",
		url = "https://leetcode.com/problems/intersection-of-two-arrays-ii/",
		difficulty = Difficulty.MEDIUM
)
public class IntersectionOfTwoArraysII
{
	public int[] intersect(int[] nums1, int[] nums2)
	{
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
		{
			return new int[]{};
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> res = new ArrayList<>();
		int left = 0;
		int right = 0;
		while (left < nums1.length && right < nums2.length)
		{
			if (nums1[left] == nums2[right])
			{
				res.add(nums1[left]);
				left++;
				right++;
			}
			else if (nums1[left] > nums2[right])
			{
				right++;
			}
			else
			{
				left++;
			}
		}

		int[] ret = new int[res.size()];
		for (int i = 0; i < res.size(); i++)
		{
			ret[i] = res.get(i);
		}

		return ret;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
		System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
	}
}
