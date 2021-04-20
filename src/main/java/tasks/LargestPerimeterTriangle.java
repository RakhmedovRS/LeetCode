package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 28-Jul-20
 */
@LeetCode(id = 976, name = "Largest Perimeter tasks.Triangle", url = "https://leetcode.com/problems/largest-perimeter-triangle/")
public class LargestPerimeterTriangle
{
	public int largestPerimeter(int[] A) {
		Arrays.sort(A);
		for (int i = A.length - 3; i >= 0; i--) {
			if (A[i] + A[i + 1] > A[i + 2]) {
				return A[i] + A[i + 1] + A[i + 2];
			}
		}

		return 0;
	}
}
