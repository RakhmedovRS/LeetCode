package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/17/2020
 */
@LeetCode(
		id = 379,
		name = "Design Phone Directory",
		url = "https://leetcode.com/problems/design-phone-directory/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignPhoneDirectory
{
	class PhoneDirectory
	{

		boolean[] used;
		LinkedList<Integer> free;

		public PhoneDirectory(int maxNumbers)
		{
			used = new boolean[10_001];
			free = new LinkedList<>();
			for (int i = 0; i < maxNumbers; i++)
			{
				free.add(i);
			}
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 *
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get()
		{
			if (free.isEmpty())
			{
				return -1;
			}

			int num = free.removeFirst();
			used[num] = true;
			return num;
		}

		/**
		 * Check if a number is available or not.
		 */
		public boolean check(int number)
		{
			return !used[number];
		}

		/**
		 * Recycle or release a number.
		 */
		public void release(int number)
		{
			if (used[number])
			{
				used[number] = false;
				free.addFirst(number);
			}
		}
	}
}
