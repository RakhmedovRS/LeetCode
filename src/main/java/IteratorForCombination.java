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
	class CombinationIterator {

		List<String> permutations;
		int pos;

		public CombinationIterator(String characters, int combinationLength) {
			permutations = new ArrayList<>();
			generatePermutations(characters.toCharArray(), 0, new char[combinationLength], 0, permutations);
			pos = 0;
		}

		public String next() {
			return permutations.get(pos++);
		}

		public boolean hasNext() {
			return pos < permutations.size();
		}

		private void generatePermutations(char[] chars, int charsPos, char[] current, int currentPos, List<String> answer) {
			if (currentPos == current.length)
			{
				answer.add(String.valueOf(current));
				return;
			}

			if (charsPos == chars.length)
			{
				return;
			}

			for (int i = charsPos; i < chars.length; i++)
			{
				current[currentPos] = chars[i];
				generatePermutations(chars, i + 1, current, currentPos + 1, answer);
			}
		}
	}
}
