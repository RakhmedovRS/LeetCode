import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutation Sequence
 * LeetCode 60
 *
 * @author RakhmedovRS
 * @created 02-Mar-20
 */
public class PermutationSequence1
{
	public String getPermutation(int n, int k)
	{
		int[] values = new int[n];
		for (int i = 0; i < n; i++)
		{
			values[i] = i + 1;
		}

		List<List<Integer>> permutations = new ArrayList<>();
		getPermutation(values, k, permutations, new LinkedList<>());

		return convertArrayToString(permutations.get(permutations.size() - 1));
	}

	public void getPermutation(int[] values, int k, List<List<Integer>> permutations, LinkedList<Integer> currentPermutation)
	{
		if (values.length == 0)
		{
			permutations.add(new ArrayList<>(currentPermutation));
			return;
		}

		for (int i = 0; i < values.length; i++)
		{
			if (permutations.size() == k)
			{
				return;
			}
			currentPermutation.addLast(values[i]);
			getPermutation(getSubArray(values, i), k, permutations, currentPermutation);
			currentPermutation.removeLast();
		}
	}

	private String convertArrayToString(List<Integer> values)
	{
		StringBuilder stringBuilder = new StringBuilder(values.size());
		for (int val : values)
		{
			stringBuilder.append(val);
		}

		return stringBuilder.toString();
	}

	private int[] getSubArray(int[] values, int excludedIndex)
	{
		int[] subArray = new int[values.length - 1];
		for (int i = 0, j = 0; i < values.length; i++)
		{
			if (i != excludedIndex)
			{
				subArray[j++] = values[i];
			}
		}

		return subArray;
	}
}
