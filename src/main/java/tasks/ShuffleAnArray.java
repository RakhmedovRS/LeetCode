package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(
	id = 384,
	name = "Shuffle an Array",
	url = "https://leetcode.com/problems/shuffle-an-array/",
	difficulty = Difficulty.MEDIUM
)
public class ShuffleAnArray
{
	class Solution
	{
		private int[] array;
		private int[] original;

		private Random rand = new Random();

		private List<Integer> getArrayCopy()
		{
			List<Integer> asList = new ArrayList<>();
			for (int i = 0; i < array.length; i++)
			{
				asList.add(array[i]);
			}
			return asList;
		}

		public Solution(int[] nums)
		{
			array = nums;
			original = nums.clone();
		}

		public int[] reset()
		{
			array = original;
			original = original.clone();
			return array;
		}

		public int[] shuffle()
		{
			List<Integer> aux = getArrayCopy();
			for (int i = 0; i < array.length; i++)
			{
				array[i] = aux.remove(rand.nextInt(aux.size()));
			}

			return array;
		}
	}
}
