import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 2/26/2021
 */
@LeetCode(
	id = 775,
	name = "Global and Local Inversions",
	url = "https://leetcode.com/problems/global-and-local-inversions/",
	difficulty = Difficulty.MEDIUM
)
public class GlobalAndLocalInversions
{
	public boolean isIdealPermutation(int[] A)
	{
		int local = 0;
		int global = 0;

		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < A.length; i++)
		{
			if (i + 1 < A.length && A[i] > A[i + 1])
			{
				local++;
			}
			treeSet.add(i);
		}

		for (int j : A)
		{
			treeSet.remove(j);
			global += treeSet.headSet(j).size();
		}

		return local == global;
	}
}
