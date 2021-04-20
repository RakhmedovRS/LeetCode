package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(id = 384, name = "Shuffle an Array", url = "https://leetcode.com/problems/shuffle-an-array/")
public class ShuffleAnArray
{
	class Solution
	{
		private int[] original;
		private int[] shuffled;
		Random random;

		public Solution(int[] nums)
		{
			original = nums;
			shuffled = nums;
			random = new Random();
		}

		/**
		 * Resets the array to its original configuration and return it.
		 */
		public int[] reset()
		{
			return Arrays.copyOf(original, original.length);
		}

		/**
		 * Returns a random shuffling of the array.
		 */
		public int[] shuffle()
		{
			original = shuffled;
			shuffled = Arrays.copyOf(original, original.length);
			for (int i = 0; i < shuffled.length; i++)
			{
				swap(shuffled, i, random.nextInt(shuffled.length - 1));
			}
			return shuffled;
		}

		private void swap(int[] shuffled, int left, int right)
		{
			int temp = shuffled[left];
			shuffled[left] = shuffled[right];
			shuffled[right] = temp;
		}
	}
}
