import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@LeetCode(id = 1286, name = "Iterator for Combination", url = "https://leetcode.com/problems/iterator-for-combination/")
public class IteratorForCombination
{
	class CombinationIterator
	{
		List<String> permutations;
		int currentPos;

		public CombinationIterator(String characters, int combinationLength)
		{
			permutations = new ArrayList<>();
			generatePermutations(characters, 0, combinationLength, new StringBuilder(), permutations);
		}

		public String next()
		{
			return permutations.get(currentPos++);
		}

		public boolean hasNext()
		{
			return currentPos < permutations.size();
		}

		private void generatePermutations(String source, int startPost, int steps, StringBuilder builder, List<String> permutations)
		{
			if (steps == 0)
			{
				permutations.add(builder.toString());
				return;
			}

			for (int i = startPost; i < source.length(); i++)
			{
				builder.append(source.charAt(i));
				generatePermutations(source, i + 1, steps - 1, builder, permutations);
				builder.deleteCharAt(builder.length() - 1);
			}
		}
	}
}
