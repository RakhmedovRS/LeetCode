package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/25/2021
 */
@LeetCode(
		id = 2116,
		name = "Check if a Parentheses String Can Be Valid",
		url = "https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfParenthesesStringCanBeValid {
	public boolean canBeValid(String s, String locked) {
		LinkedList<Integer> list = new LinkedList<>();
		boolean[] locks = new boolean[locked.length()];
		for (int i = 0; i < locked.length(); i++) {
			if (locked.charAt(i) == '1') {
				locks[i] = true;
			}
		}

		boolean[] removed = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (!locks[i]) {
				continue;
			}

			if (s.charAt(i) == '(') {
				list.addLast(i);
			}
			else if (s.charAt(i) == ')') {
				if (!list.isEmpty() && s.charAt(list.getLast()) == '(') {
					removed[list.removeLast()] = true;
					removed[i] = true;
				}
				else {
					list.addLast(i);
				}
			}
		}

		list.clear();
		for (int i = 0; i < s.length(); i++) {

			if (removed[i]) {
				continue;
			}

			if (list.isEmpty()) {
				list.addLast(i);
				continue;
			}

			char prev = s.charAt(list.getLast());
			boolean prevCanBeChanged = !locks[list.getLast()];

			char curr = s.charAt(i);
			boolean currCanBeChanged = !locks[i];

			if ((prev == '(' || prevCanBeChanged) && (curr == ')' || currCanBeChanged)) {
				if (prevCanBeChanged && currCanBeChanged) {
					list.addLast(i);
				}
				else {
					list.removeLast();
				}
			}
			else {
				list.addLast(i);
			}
		}

		if (list.size() % 2 != 0) {
			return false;
		}

		while (!list.isEmpty()) {
			boolean prevCanBeChanged = !locks[list.removeLast()];
			boolean currCanBeChanged = !locks[list.removeLast()];
			if (!prevCanBeChanged || !currCanBeChanged) {
				return false;
			}
		}


		return true;
	}
}
