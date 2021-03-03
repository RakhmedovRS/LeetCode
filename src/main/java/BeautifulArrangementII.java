import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/3/2021
 */
@LeetCode(
	id = 667,
	name = "Beautiful Arrangement II",
	url = "https://leetcode.com/problems/beautiful-arrangement-ii/",
	difficulty = Difficulty.MEDIUM
)
public class BeautifulArrangementII
{
	public int[] constructArray(int n, int k)
	{
		int[] answer = new int[n];
		for (int i = 0; i < n; i++)
		{
			answer[i] = i + 1;
		}

		for (int i = 1; i < k; i++)
		{
			reverse(i, answer);
		}
		return answer;
	}

	private void reverse(int left, int[] array)
	{
		int right = array.length - 1;
		int temp;
		while (left < right)
		{
			temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}
}
