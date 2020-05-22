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
		for (int[] row : A)
		{
			int left = 0;
			int right = A.length - 1;
			while (left < right)
			{
				int temp = row[left];
				row[left] = Math.abs(row[right] - 1);
				row[right] = Math.abs(temp - 1);
				left++;
				right--;
			}

			if (left == right)
			{
				row[right] = Math.abs(row[right] - 1);
			}
		}

		return A;
	}
}
