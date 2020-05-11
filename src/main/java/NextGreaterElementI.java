import common.LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11-May-20
 */
@LeetCode(id = 496, name = "Next Greater Element I", url = "https://leetcode.com/problems/next-greater-element-i/")
public class NextGreaterElementI
{
	public int[] nextGreaterElement(int[] nums1, int[] nums2)
	{
		Map<Integer, Integer> valueToPosition = new HashMap<>();
		Deque<Integer> stack = new LinkedList<>();
		for (int num : nums2)
		{
			if (!stack.isEmpty() && stack.peek() < num)
			{
				valueToPosition.put(stack.pop(), num);
			}
			stack.push(num);
		}

		for (int i = 0; i < nums1.length; i++)
		{
			nums1[i] = valueToPosition.getOrDefault(nums1[i], -1);
		}

		return nums1;
	}
}
