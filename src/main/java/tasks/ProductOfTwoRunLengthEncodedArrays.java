package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/23/2021
 */
@LeetCode(
	id = 1868,
	name = "Product of Two Run-Length Encoded Arrays",
	url = "https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class ProductOfTwoRunLengthEncodedArrays
{
	public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2)
	{
		LinkedList<int[]> queue = new LinkedList<>();
		int e1Index = 0;
		int e2Index = 0;
		int[] e1Pos = encoded1[e1Index++];
		int[] e2Pos = encoded2[e2Index++];
		int product;
		while ((e1Index < encoded1.length || e1Pos[1] > 0) && (e2Index < encoded2.length || e2Pos[1] > 0))
		{
			int min = Math.min(e1Pos[1], e2Pos[1]);

			product = e1Pos[0] * e2Pos[0];
			if (queue.isEmpty() || queue.peek()[0] != product)
			{
				queue.push(new int[]{product, min});
			}
			else
			{
				queue.peek()[1] += min;
			}

			e1Pos[1] -= min;
			if (e1Pos[1] == 0 && e1Index < encoded1.length)
			{
				e1Pos = encoded1[e1Index++];
			}

			e2Pos[1] -= min;
			if (e2Pos[1] == 0 && e2Index < encoded2.length)
			{
				e2Pos = encoded2[e2Index++];
			}
		}

		LinkedList<List<Integer>> answer = new LinkedList<>();
		while (!queue.isEmpty())
		{
			answer.addFirst(Arrays.asList(queue.peek()[0], queue.pop()[1]));
		}

		return answer;
	}
}
