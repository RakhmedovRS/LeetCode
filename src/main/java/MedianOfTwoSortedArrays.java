import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(id = 4, name = "Median of Two Sorted Arrays", url = "https://leetcode.com/problems/median-of-two-sorted-arrays/")
public class MedianOfTwoSortedArrays
{
	public double findMedianSortedArrays(int[] X, int[] Y)
	{
		//if X length is greater than switch them so that X is smaller than Y.
		if (X.length > Y.length)
		{
			return findMedianSortedArrays(Y, X);
		}

		int x = X.length;
		int y = Y.length;

		int low = 0;
		int high = x;
		while (low <= high)
		{
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : X[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : X[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : Y[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : Y[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX)
			{
				//We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0)
				{
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				}
				else
				{
					return Math.max(maxLeftX, maxLeftY);
				}
			}
			else if (maxLeftX > minRightY)
			{ //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			}
			else
			{ //we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 4, 5}, new int[]{2, 3}));
	}
}
