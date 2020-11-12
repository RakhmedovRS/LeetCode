import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/12/2020
 */
@LeetCode(id = 923, name = "3Sum With Multiplicity", url = "https://leetcode.com/problems/3sum-with-multiplicity/")
public class ThreeSumWithMultiplicity
{
	public int threeSumMulti(int[] A, int target)
	{
		int mod = 1_000_000_007;
		Arrays.sort(A);
		int count = 0;
		int searchSum;
		for (int left = 0; left < A.length; left++)
		{
			searchSum = target - A[left];
			int middle = left + 1;
			int right = A.length - 1;
			while (middle < right)
			{
				if (A[middle] + A[right] < searchSum)
				{
					middle++;
				}
				else if (A[middle] + A[right] > searchSum)
				{
					right--;
				}
				else if (A[middle] != A[right])
				{
					int l = 1;
					int r = 1;
					while (middle + 1 < right && A[middle] == A[middle + 1])
					{
						l++;
						middle++;
					}

					while (right - 1 > middle && A[right] == A[right - 1])
					{
						r++;
						right--;
					}

					count = ((count + (l * r)) % mod);
					middle++;
					right--;
				}
				else
				{
					count = ((count + (right - middle + 1) * (right - middle) / 2) % mod);
					break;
				}
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
	}
}
