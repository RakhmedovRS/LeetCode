package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 5/2/2021
 */
@LeetCode(
	id = 1850,
	name = "Minimum Adjacent Swaps to Reach the Kth Smallest Number",
	url = "https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumAdjacentSwapsToReachTheKthSmallestNumber
{
	public int getMinSwaps(String num, int k)
	{
		char[] original = num.toCharArray();
		char[] swapped = num.toCharArray();
		getMinSwaps(swapped, k);
		int swaps = 0;
		for (int i = 0; i < original.length; i++)
		{
			if (original[i] != swapped[i])
			{
				for (int j = i + 1; j < original.length; j++)
				{
					if (swapped[i] == original[j])
					{
						swaps += j - i;
						swap(original, i, j);
						break;
					}
				}
			}
		}

		return swaps;
	}

	private void swap(char[] original, int left, int right)
	{
		while (right > left)
		{
			char temp = original[right - 1];
			original[right - 1] = original[right];
			original[right] = temp;
			right--;
		}
	}

	public void getMinSwaps(char[] chars, int k)
	{
		if (k == 0)
		{
			return;
		}

		for (int left = chars.length - 1; left >= 0; left--)
		{
			if (chars[left] > chars[left - 1])
			{
				int pos = left;
				for (int right = left; right < chars.length; right++)
				{
					if (chars[left - 1] < chars[right] && chars[right] < chars[pos])
					{
						pos = right;
					}
				}

				char temp = chars[left - 1];
				chars[left - 1] = chars[pos];
				chars[pos] = temp;

				Arrays.sort(chars, left, chars.length);

				getMinSwaps(chars, k - 1);
				return;
			}
		}
	}
}
