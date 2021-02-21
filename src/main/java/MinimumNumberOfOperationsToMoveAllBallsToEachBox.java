import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 2/21/2021
 */
@LeetCode(
	id = 1769,
	name = "Minimum Number of Operations to Move All Balls to Each Box",
	url = "https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox
{
	public int[] minOperations(String boxes)
	{
		int[] left = new int[boxes.length()];
		int[] right = new int[boxes.length()];
		int[] answer = new int[boxes.length()];

		int count = boxes.charAt(0) - '0';
		for (int i = 1; i < boxes.length(); i++)
		{
			left[i] += left[i - 1] + count;
			count += boxes.charAt(i) - '0';
		}

		count = boxes.charAt(boxes.length() - 1) - '0';
		for (int i = boxes.length() - 2; i >= 0; i--)
		{
			right[i] += right[i + 1] + count;
			count += boxes.charAt(i) - '0';
		}

		for (int i = 0; i < boxes.length(); i++)
		{
			answer[i] += left[i] + right[i];
		}

		return answer;
	}

	public static void main(String[] args)
	{
		MinimumNumberOfOperationsToMoveAllBallsToEachBox clazz = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
		System.out.println(Arrays.toString(clazz.minOperations("001011")));
		System.out.println(Arrays.toString(clazz.minOperations("110")));
	}
}
