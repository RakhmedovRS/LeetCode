package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 02-Feb-21
 */
@LeetCode(
		id = 946,
		name = "Validate Stack Sequences",
		url = "https://leetcode.com/problems/validate-stack-sequences/",
		difficulty = Difficulty.MEDIUM
)
public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		LinkedList<Integer> list = new LinkedList<>();
		int pushedIndex = 0;
		int poppedIndex = 0;
		while (pushedIndex < pushed.length) {
			while (!list.isEmpty() && poppedIndex < popped.length && list.getLast() == popped[poppedIndex]) {
				list.removeLast();
				poppedIndex++;
			}

			list.addLast(pushed[pushedIndex++]);
		}

		while (!list.isEmpty() && poppedIndex < popped.length && list.getLast() == popped[poppedIndex]) {
			list.removeLast();
			poppedIndex++;
		}

		return list.isEmpty();
	}

	public static void main(String[] args) {
		ValidateStackSequences clazz = new ValidateStackSequences();
		System.out.println(clazz.validateStackSequences(new int[]{0}, new int[]{0}));
		System.out.println(clazz.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
	}
}
