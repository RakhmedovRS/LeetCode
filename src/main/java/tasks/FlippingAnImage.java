package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
@LeetCode(id = 832, name = "Flipping an Image", url = "https://leetcode.com/problems/flipping-an-image/")
public class FlippingAnImage
{
	public int[][] flipAndInvertImage(int[][] A)
	{
		int left;
		int right;
		int temp;
		for (int[] row : A)
		{
			left = 0;
			right = row.length - 1;
			while (left <= right)
			{
				temp = row[left];
				row[left] = row[right];
				row[right] = temp;

				row[left] = (row[left] + 1) % 2;
				if(left != right)
				{
					row[right] = (row[right] + 1) % 2;
				}
				left++;
				right--;
			}
		}

		return A;
	}
}
