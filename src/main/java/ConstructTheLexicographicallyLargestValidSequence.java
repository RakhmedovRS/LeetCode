import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/9/2021
 */
@LeetCode(
	id = 1718,
	name = "Construct the Lexicographically Largest Valid Sequence",
	url = "https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/",
	difficulty = Difficulty.MEDIUM
)
public class ConstructTheLexicographicallyLargestValidSequence
{
	public int[] constructDistancedSequence(int n)
	{
		return dfs(0, new boolean[n + 1], new int[(n - 1) * 2 + 1], false, n);
	}

	private int[] dfs(int pos, boolean[] used, int[] current, boolean usedOne, int n)
	{
		if (pos == current.length)
		{
			return current;
		}

		if (current[pos] != 0)
		{
			return dfs(pos + 1, used, current, usedOne, n);
		}

		int[] res;
		for (int i = used.length - 1; i > 1; i--)
		{
			if (!used[i])
			{
				used[i] = true;
				if (pos + i < current.length && current[pos + i] == 0)
				{
					current[pos] = i;
					current[pos + i] = i;
					res = dfs(pos + 1, used, current, usedOne, n);
					if (res != null)
					{
						return res;
					}
					current[pos + i] = 0;
				}

				used[i] = false;
			}
		}

		if (!usedOne)
		{
			current[pos] = 1;
			res = dfs(pos + 1, used, current, true, n);
			if (res != null)
			{
				return res;
			}
		}
		current[pos] = 0;
		return null;
	}

	public static void main(String[] args)
	{
		ConstructTheLexicographicallyLargestValidSequence clazz = new ConstructTheLexicographicallyLargestValidSequence();
		System.out.println(Arrays.toString(clazz.constructDistancedSequence(12))); //[12, 10, 11, 7, 5, 3, 8, 9, 3, 5, 7, 10, 12, 11, 8, 6, 9, 2, 4, 2, 1, 6, 4]
		System.out.println(Arrays.toString(clazz.constructDistancedSequence(10))); //[10,8,6,9,3,1,7,3,6,8,10,5,9,7,4,2,5,2,4]
		System.out.println(Arrays.toString(clazz.constructDistancedSequence(5))); //[5,3,1,4,3,5,2,4,2]
		System.out.println(Arrays.toString(clazz.constructDistancedSequence(3))); //[3,1,2,3,2]
	}
}
