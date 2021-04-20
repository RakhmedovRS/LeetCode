package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11-May-20
 */
@LeetCode(
	id = 496,
	name = "Next Greater Element I",
	url = "https://leetcode.com/problems/next-greater-element-i/",
	difficulty = Difficulty.EASY
)
public class NextGreaterElementI
{
	public int[] nextGreaterElement(int[] nums1, int[] nums2)
	{
		int[] memo = new int[10_001];
		Arrays.fill(memo , -1);
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < nums2.length; i++)
		{
			while (!list.isEmpty() && nums2[list.getFirst()] < nums2[i])
			{
				memo[nums2[list.removeFirst()]] = nums2[i];
			}
			list.addFirst(i);
		}

		int[] answer = new int[nums1.length];
		for (int i = 0; i < answer.length; i++)
		{
			answer[i] = memo[nums1[i]];
		}

		return answer;
	}
}
