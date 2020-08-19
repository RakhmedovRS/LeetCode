import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 19-Aug-20
 */
@LeetCode(id = 454, name = "4Sum II", url = "https://leetcode.com/problems/4sum-ii/")
public class FourSumII
{
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		Map<Integer, Integer> abMap = new HashMap<>();
		for (int a : A) {
			for (int b : B) {
				abMap.put(a + b, abMap.getOrDefault(a + b, 0) + 1);
			}
		}

		for (int c : C) {
			for (int d : D) {
				count += abMap.getOrDefault(-(c + d), 0);
			}
		}
		return count;
	}
}
